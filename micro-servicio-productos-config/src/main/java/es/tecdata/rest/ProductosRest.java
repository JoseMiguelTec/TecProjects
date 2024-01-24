package es.tecdata.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.tecdata.models.Producto;
import es.tecdata.services.iProductoService;

@RestController
@RefreshScope
public class ProductosRest {

	@Autowired
	private iProductoService productoService;

	// Con puerto dinamico esto no funciona
	// @Value("${server.port}")
	// private Integer port;

	@Autowired
	private HttpServletRequest request;

	// INyectamos el valor de la propiedad modo del servidor de configuracion
	@Value("${configuration.modo}")
	private String configurationModo;

	// http://localhost:8001/listar
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.consultarTodos().stream().map(prod -> {
			prod.setPort(request.getLocalPort());
			return prod;
		}).collect(Collectors.toList());
	}

	// http://localhost:8001/buscar/4
	@GetMapping("/buscar/{codigo}")
	public Producto buscar(@PathVariable(name = "codigo") Long id) throws InterruptedException {

		System.out.println("*********");
		System.out.println("Estamos en modo " + configurationModo);
		System.out.println("*********");

		Producto producto = productoService.buscarProducto(id);

		// Si no encontramos el producto lanzamos una excepcion
		if (producto == null) {
			throw new RuntimeException("Error al buscar el producto");
		}

		// Por defecto, todos los microservicios esperan un maximo de 1 segundo en
		// obtener la respuesta
		// Si la peticion, supera ese segundo devuelve un error de TimeOut
		// Provoco ese error parando la ejecucion 10 segundos
		// Thread.sleep(10_000);

		// Prueba de llamadas lentas
		// Si paro la ejecucion mas de 2 segundos se considuera una conexion lenta
		if (id.equals(5L)) {
			Thread.sleep(4_000);
		}

		// Prueba de timeout de 6 segundos
		if (id.equals(1L)) {
			Thread.sleep(7_000);
		}

		// producto.setPort(port);
		producto.setPort(request.getLocalPort());
		return producto;
	}
}
