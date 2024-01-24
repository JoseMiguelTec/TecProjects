package es.tecdata.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.tecdata.models.Producto;
import es.tecdata.services.iProductoService;

@RestController
public class ProductosRest {

	@Autowired
	private iProductoService productoService;

	// http://localhost:8001/listar
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.consultarTodos();
	}

	// http://localhost:8001/buscar/4
	@GetMapping("/buscar/{codigo}")
	public Producto buscar(@PathVariable(name = "codigo") Long id) {
		return productoService.buscarProducto(id);
	}
}
