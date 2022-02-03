package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/products")
	public String products(
			@RequestParam(name="name", required = false, defaultValue = "Cacao") String name,
			@RequestParam(name="brand", required = false, defaultValue = "Hacendado") String brand,
			@RequestParam(name="category", required = false, defaultValue = "Dulce") String category,
			Model model) {
					//atributo thymeleaf
		model.addAttribute("contenido", "PRODUCTOS");
		model.addAttribute("name", name);
		model.addAttribute("brand", brand);
		model.addAttribute("category", category);
		
		return "products";
	}
	
	@RequestMapping("/services")
	public String services()  {
		return "services";
	}
	
}
