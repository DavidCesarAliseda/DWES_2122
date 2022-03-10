package org.iesalixar.servidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("contenido","ABOUT");
		return "about";
	}
	
	@RequestMapping("/products")
	public String products(Model model) {
		
		model.addAttribute("contenido","PRODUCTOS");
		return "products";
	}
	
	@RequestMapping("/services")
	public String services(Model model)  {
		model.addAttribute("contenido","SERVICIOS");
		return "services";
	}

}
