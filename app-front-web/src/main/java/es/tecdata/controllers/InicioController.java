package es.tecdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class InicioController {

	@RequestMapping(method = RequestMethod.GET, value = "")
	public String inicio() {
		return "index";
	}

}
