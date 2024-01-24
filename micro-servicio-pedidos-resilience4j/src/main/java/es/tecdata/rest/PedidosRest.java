package es.tecdata.rest;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.tecdata.models.Pedido;
import es.tecdata.models.Producto;
import es.tecdata.services.IPedidoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
public class PedidosRest {

	@Autowired
	@Qualifier(value = "serviceFeign")
	// @Resource(name = "serviceFeign")
	private IPedidoService pedidoService;

	// En el caso de recibir una excepcion llamamos al metodo manejarError.
	@CircuitBreaker(fallbackMethod = "manejarError", name = "pedidoscb")
	// http://localhost:8002/crear/3/cantidad/100
	@GetMapping("/crear/{id}/cantidad/{cantidad}")
	public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad) {
		return pedidoService.crearPedido(id, cantidad);
	}

	// En el caso de recibir una excepcion llamamos al metodo manejarError.
	@CircuitBreaker(fallbackMethod = "manejarError2", name = "pedidoscb")
	@TimeLimiter(name = "pedidoscb")
	// http://localhost:8002/crear2/3/cantidad/100
	@GetMapping("/crear2/{id}/cantidad/{cantidad}")
	public CompletableFuture<Pedido> crearPedido2(@PathVariable Long id, @PathVariable int cantidad) {
		return CompletableFuture.supplyAsync(() -> pedidoService.crearPedido(id, cantidad));
	}

	public Pedido manejarError(Long id, int cantidad, Throwable exception) {
		System.out.println(exception.getMessage() + "***");
		Producto producto = new Producto(id, "Producto vacio", 0);
		return new Pedido(producto, cantidad);
	}

	public CompletableFuture<Pedido> manejarError2(Long id, int cantidad, Throwable exception) {
		System.out.println(exception.getMessage() + "***");
		Producto producto = new Producto(id, "Producto lento", 0);
		return CompletableFuture.supplyAsync(() -> new Pedido(producto, cantidad));
	}

}
