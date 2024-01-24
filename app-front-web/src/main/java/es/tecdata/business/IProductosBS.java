package es.tecdata.business;

import java.util.List;

import es.tecdata.models.Carrito;
import es.tecdata.models.Producto;

public interface IProductosBS {

	List<Producto> obtenerTodos();

	Producto buscar(Long id);

	Carrito crear(String usuario);

	Carrito consultar(String usuario);

	void agregar(Long id, int cantidad, String usuario);

	void eliminar(Long id, String usuario);

}
