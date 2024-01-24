package es.tecdata.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.tecdata.models.Producto;

// Si vamos a tener varias instancias de micro-servicio-productos no se puede lanzar la peticion siempre al puerto 8001
//@FeignClient(url = "localhost:8001", name = "servicio-productos")
@FeignClient(name = "servicio-productos")
public interface ProductosClienteFeign {

	@GetMapping("/buscar/{codigo}")
	public Producto buscar(@PathVariable(name = "codigo") Long id);

}
