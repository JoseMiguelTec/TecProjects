package es.tecdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tecdata.models.Producto;
import es.tecdata.persistence.ProductosDAO;

@Service
public class ProductoServiceImpl implements iProductoService {

	@Autowired
	private ProductosDAO productosDAO;

	@Override
	public List<Producto> consultarTodos() {
		return productosDAO.findAll();
	}

	@Override
	public Producto buscarProducto(Long id) {
		return productosDAO.findById(id);
	}

}
