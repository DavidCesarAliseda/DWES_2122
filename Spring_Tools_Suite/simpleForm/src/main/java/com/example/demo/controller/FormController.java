package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MatriculaDTO;
import com.example.demo.dto.RegistroDTO;

@Controller
@RequestMapping("/forms")
public class FormController {
	
	@GetMapping("/registroForm")
	public String registroForm(Model model) {
		
		RegistroDTO registro = new RegistroDTO();
		model.addAttribute("registro", registro);
		
		return "forms/registroForm";
	}
	
	@PostMapping("/registroForm")
	public String registroForm(@ModelAttribute RegistroDTO registro, Model model) {
		model.addAttribute("registro", registro);
		return "forms/registroForm";
	}
	
	@GetMapping("/matriculaForm")
	public String matriculaForm(Model model) {
		
		MatriculaDTO matricula = new MatriculaDTO();
		model.addAttribute("matricula", matricula);
		
		return "forms/matriculaForm";
	}
	
	@PostMapping("/matriculaForm")
	public String matriculaForm(@ModelAttribute MatriculaDTO matricula, Model model) {
		model.addAttribute("matricula", matricula);
		return "forms/matriculaForm";
	}
}
