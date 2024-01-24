package es.tecdata.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.tecdata.business.IProductosBS;
import es.tecdata.models.Carrito;

@Controller
@RequestMapping("/")
public class ComprarController {

	@Autowired
	private IProductosBS productosBS;

	@RequestMapping(method = RequestMethod.POST, value = "comprar")
	public String addPedido(long id, int cantidad, HttpServletRequest request) {
		String usuario = null;
		boolean logado = false;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("nombreUsuario".equals(cookie.getName())) {
				usuario = cookie.getValue();
				logado = true;
			}
		}

		// Si no encuentro la cookie con el nombre de usuario le mando a login.
		if (!logado) {
			return "formLogin";
		}

		// Si esta logado:
		// buscar el carrito de ese usuario
		// crear el pedido con el id y la cantidad
		// guardar el carrito como atributo de peticion
		productosBS.agregar(id, cantidad, usuario);
		Carrito carrito = productosBS.consultar(usuario);
		request.setAttribute("carrito", carrito);
		return "mostrarCarrito";
	}

	@RequestMapping(method = RequestMethod.POST, value = "eliminar")
	public String eliminarPedido(long id, HttpServletRequest request) {
		String usuario = null;
		boolean logado = false;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("nombreUsuario".equals(cookie.getName())) {
				usuario = cookie.getValue();
				logado = true;
			}
		}

		// Si no encuentro la cookie con el nombre de usuario le mando a login.
		if (!logado) {
			return "formLogin";
		}
		productosBS.eliminar(id, usuario);
		Carrito carrito = productosBS.consultar(usuario);
		request.setAttribute("carrito", carrito);
		return "mostrarCarrito";
	}

}
