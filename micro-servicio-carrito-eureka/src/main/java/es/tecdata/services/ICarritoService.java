package es.tecdata.services;

import es.tecdata.models.Carrito;

public interface ICarritoService {

	Carrito crear(String usuario);

	Carrito consultar(String usuario);

	Carrito agregarPedido(Long id, int cantidad, String usuario);

	Carrito eliminarPedido(Long id, String usuario);

}
