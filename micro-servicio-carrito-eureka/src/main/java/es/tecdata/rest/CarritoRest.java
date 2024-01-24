package es.tecdata.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import es.tecdata.models.Carrito;
import es.tecdata.services.ICarritoService;

@RestController
public class CarritoRest {

	@Autowired
	private ICarritoService carritoService;

	// http://localhost:8003/crear/Pepe
	@PostMapping("/crear/{usuario}")
	public Carrito crear(@PathVariable String usuario) {
		return carritoService.crear(usuario);
	}

	// http://localhost:8003/consultar/Pepe
	@GetMapping("/consultar/{usuario}")
	public Carrito consultar(@PathVariable String usuario) {
		return carritoService.consultar(usuario);
	}

	// http://localhost:8003/agregar/id/3/cantidad/100/usuario/Pepe
	@PutMapping("/agregar/id/{id}/cantidad/{cantidad}/usuario/{usuario}")
	public Carrito agregarPedido(@PathVariable Long id, @PathVariable int cantidad, @PathVariable String usuario) {
		return carritoService.agregarPedido(id, cantidad, usuario);
	}

	// http://localhost:8003/eliminar/id/3/usuario/Pepe
	@DeleteMapping("/eliminar/id/{id}/usuario/{usuario}")
	public Carrito eliminarPedido(@PathVariable Long id, @PathVariable String usuario) {
		return carritoService.eliminarPedido(id, usuario);
	}

}
