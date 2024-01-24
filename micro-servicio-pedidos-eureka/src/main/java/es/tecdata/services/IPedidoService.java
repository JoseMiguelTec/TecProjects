package es.tecdata.services;

import es.tecdata.models.Pedido;

public interface IPedidoService {
	
	Pedido crearPedido(Long id, int cantidad);

}
