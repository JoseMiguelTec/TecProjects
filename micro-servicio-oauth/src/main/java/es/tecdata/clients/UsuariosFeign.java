package es.tecdata.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.tecdata.models.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface UsuariosFeign {

	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);

}
