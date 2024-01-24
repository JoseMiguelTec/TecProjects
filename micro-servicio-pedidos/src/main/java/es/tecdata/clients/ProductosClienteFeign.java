package es.tecdata.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.tecdata.models.Producto;

@FeignClient(url = "localhost:8001", name = "servicio-productos")
public interface ProductosClienteFeign {

	@GetMapping("/buscar/{codigo}")
	public Producto buscar(@PathVariable(name = "codigo") Long id);

}
