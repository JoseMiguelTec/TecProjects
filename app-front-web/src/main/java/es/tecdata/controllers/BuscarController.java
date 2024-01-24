package es.tecdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.tecdata.business.IProductosBS;
import es.tecdata.models.Producto;

@Controller
@RequestMapping("/buscar")
public class BuscarController {
	@Autowired
	private IProductosBS productosBS;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrarFormulario(Model model) {
		model.addAttribute("prod", new Producto());
		return "formBuscar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String procesarFormulario(Producto producto, Model model) {
		Producto encontrado = productosBS.buscar(producto.getID());
		if (encontrado.getID() == null) {
			model.addAttribute("msg", "Lo siento este producto no existe");
			return "mostrarMensaje";
		}
		model.addAttribute("encontrado", encontrado);

		return "mostrarProducto";
	}

}
