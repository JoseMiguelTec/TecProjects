package es.tecdata.services;

import java.util.List;

import es.tecdata.models.Producto;

public interface iProductoService {
	
	List<Producto> consultarTodos();
	
	Producto buscarProducto(Long id);

}
