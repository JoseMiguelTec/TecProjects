package es.tecdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.tecdata.business.IProductosBS;
import es.tecdata.models.Producto;

@Controller
@RequestMapping("/")
public class TodosController {

	@Autowired
	private IProductosBS productosBS;

	@RequestMapping("todos")
	public String execute(Model model) {
		List<Producto> lista = productosBS.obtenerTodos();
		model.addAttribute("lista", lista);
		return "mostrarTodos";
	}

}
