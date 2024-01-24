package es.tecdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tecdata.clients.PedidosClienteFeign;
import es.tecdata.models.Carrito;
import es.tecdata.models.Pedido;
import es.tecdata.persistence.CarritoDAO;

@Service
public class CarritoServiceFeign implements ICarritoService {
	@Autowired
	private PedidosClienteFeign pedidosClienteFeign;

	@Autowired
	private CarritoDAO carritoDao;

	@Override
	public Carrito crear(String usuario) {
		Carrito carrito = new Carrito();
		carrito.setUsuario(usuario);
		return carritoDao.save(carrito);
	}

	@Override
	public Carrito consultar(String usuario) {
		return carritoDao.findByUsuario(usuario);
	}

	@Override
	public Carrito agregarPedido(Long id, int cantidad, String usuario) {
		Pedido pedido = pedidosClienteFeign.crear(id, cantidad);
		Carrito carrito = this.consultar(usuario);
		carrito.getContenido().add(pedido);
		double importe = carrito.getImporte() + (pedido.getProducto().getPrecio()) * cantidad;
		carrito.setImporte(importe);
		return carritoDao.save(carrito);
	}

	@Override
	public Carrito eliminarPedido(Long id, String usuario) {
		Carrito carrito = this.consultar(usuario);
		List<Pedido> contenido = carrito.getContenido();
		Pedido encontrado = null;
		for (Pedido pedido : contenido) {
			if (pedido.getProducto().getID() == id) {
				encontrado = pedido;
				break;
			}
		}
		contenido.remove(encontrado);
		double importe = carrito.getImporte() - (encontrado.getProducto().getPrecio() * encontrado.getCantidad());
		carrito.setImporte(importe);
		return carritoDao.save(carrito);
	}

}
