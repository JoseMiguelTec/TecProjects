package es.tecdata.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.tecdata.models.Pedido;
import es.tecdata.services.IPedidoService;

@RestController
public class PedidosRest {

	@Autowired
	@Qualifier(value = "serviceRestTemplate")
	// @Resource(name = "serviceFeign")
	private IPedidoService pedidoService;

	// http://localhost:8002/crear/3/cantidad/100
	@GetMapping("/crear/{id}/cantidad/{cantidad}")
	public Pedido crearPedido(@PathVariable Long id, @PathVariable int cantidad) {
		return pedidoService.crearPedido(id, cantidad);
	}

}
