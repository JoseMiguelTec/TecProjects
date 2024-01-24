package es.tecdata.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.tecdata.models.Pedido;
import es.tecdata.models.Producto;
import es.tecdata.services.IPedidoService;

@RestController
public class PedidosRest {

	@Autowired
	@Qualifier(value = "serviceFeign")
	// @Resource(name = "serviceFeign")
	private IPedidoService pedidoService;

	// En el caso de recibir una excepcion llamamos al metodo manejarError.
	@HystrixCommand(fallbackMethod = "manejarError")
	// http://localhost:8002/crear/3/cantidad/100
	@GetMapping("/crear/{id}/cantidad/{cantidad}")
	public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad) {
		return pedidoService.crearPedido(id, cantidad);
	}

	public Pedido manejarError(Long id, int cantidad, Throwable exception) {
		System.out.println(exception.getMessage() + "***");
		Producto producto = new Producto(id, "Producto vacio", 0);
		return new Pedido(producto, cantidad);
	}

}
