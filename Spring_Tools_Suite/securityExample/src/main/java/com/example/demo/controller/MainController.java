package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/usuario")
	public String employees() {
		return "usuario";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
}
