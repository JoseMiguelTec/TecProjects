package es.tecdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.tecdata.models.Pedido;
import es.tecdata.models.Producto;

@Service("serviceRestTemplate")
public class PedidoServiceRestTemplate implements IPedidoService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Pedido crearPedido(Long id, int cantidad) {
		// Buscar el producto con el id
		String url = "http://localhost:8001/buscar/{codigo}";
		Producto producto = restTemplate.getForObject(url, Producto.class, id);

		// Crear el pedido con el producto y la cantidad
		return new Pedido(producto, cantidad);
	}

}
