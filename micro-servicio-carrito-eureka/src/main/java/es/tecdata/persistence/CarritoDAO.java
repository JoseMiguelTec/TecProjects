package es.tecdata.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.tecdata.models.Carrito;

@RepositoryRestResource(collectionResourceRel = "CARRITOS", path = "carritos")
public interface CarritoDAO extends MongoRepository<Carrito, String> {

	// Consultar todos los carritos
	// http://localhost:8003/carritos

	// Buscar un carrito por su id
	// http://localhost:8003/carritos/qwertyuiop

	// Podemos utilizar los metodos hereados y tambien crear metodos personalizados
	// utilizando keywords
	// http;//localhost:8003/carritos/search/findByUsuario?usuario=Pepe
	public Carrito findByUsuario(String usuario);

	// Ejemplos de metodos personalizados
	// http;//localhost:8003/carritos/search/orderByImport
	public List<Carrito> OrderByImporte();

	// http;//localhost:8003/carritos/search/findeByImporteBetween?min=100&max=500
	public List<Carrito> findByImporteBetween(double min, double max);

	// Si queremos ver todos los metodos personalizados
	// http;//localhost:8003/carritos/search
}
