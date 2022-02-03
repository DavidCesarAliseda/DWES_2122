package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UserDTO;

@Controller
@RequestMapping("/forms")
public class FormExampleControler {
	
	
	@GetMapping("/simpleform")
	public String simpleForm(Model model) {
		
		ProductDTO product = new ProductDTO();		
		model.addAttribute("product", product);
		
		return "forms/simpleform";
		
	}
	
	@PostMapping("/simpleform")
	public String simpleFormPost(@ModelAttribute ProductDTO product, Model model) {
		model.addAttribute("product", product);
		return "forms/simpleform";
		
	}
	
	@GetMapping("/complexform")
	public String complexForm(Model model) {
		model.addAttribute("user",new UserDTO());
		return "forms/complexform";
		
	}
	
	@PostMapping("/complexform")
	public String complexFormPost() {
		return "forms/complexform";
		
	}

}
