package es.tecdata.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.tecdata.business.IProductosBS;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IProductosBS productosBS;

	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {

		String usuario = request.getParameter("user");
		Cookie cookie = new Cookie("nombreUsuario", usuario);
		response.addCookie(cookie);
		cookie.setMaxAge(24 * 60 * 60);

		// Crear el carrito al usuario
		productosBS.crear(usuario);

		return "index";
	}

}
