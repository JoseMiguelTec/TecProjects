package es.tecdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tecdata.clients.ProductosClienteFeign;
import es.tecdata.models.Pedido;
import es.tecdata.models.Producto;

@Service("serviceFeign")
// @Primary
public class PedidoServiceFeign implements IPedidoService {

	@Autowired
	private ProductosClienteFeign clienteFeign;

	@Override
	public Pedido crearPedido(Long id, int cantidad) {
		Producto producto = clienteFeign.buscar(id);
		return new Pedido(producto, cantidad);
	}

}
