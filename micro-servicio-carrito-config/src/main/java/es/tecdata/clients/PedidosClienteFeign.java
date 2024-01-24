package es.tecdata.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.tecdata.models.Pedido;

@FeignClient(name = "servicio-pedidos")
public interface PedidosClienteFeign {

	@GetMapping("/crear/{id}/cantidad/{cantidad}")
	public Pedido crear(@PathVariable(name = "id") Long id, @PathVariable(name = "cantidad") int cantidad);

}
