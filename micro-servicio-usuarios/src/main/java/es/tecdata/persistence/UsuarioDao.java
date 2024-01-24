package es.tecdata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.tecdata.models.Usuario;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	@RestResource(path = "buscar-username")
	public Usuario findByUsername(String username);
}
