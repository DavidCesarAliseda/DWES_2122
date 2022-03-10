package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AlumnoDTO;
import com.example.demo.dto.ConciertoDTO;

@Controller
@RequestMapping("/forms")
public class MainController {
	
	@GetMapping("/matricula")
	public String simpleForm(Model model) {
		
		AlumnoDTO alumno = new AlumnoDTO();		
		model.addAttribute("alumno", alumno);
		
		ArrayList<String> materias = new ArrayList<>() ;
		materias.add("Servidor");
		materias.add("Cliente");
		materias.add("Diseño");
		materias.add("BBDD");
		materias.add("Lenguaje de marcas");
		materias.add("Sistemas");
		model.addAttribute("materias", materias);
						
		return "forms/matricula";
		
	}
	
	@PostMapping("/matricula")
	public String simpleFormPost(@ModelAttribute AlumnoDTO alumno, Model model) {
		model.addAttribute("alumno", alumno);
		return "forms/matricula";
		
	}
	
	@GetMapping("/concierto")
	public String formConcierto(Model model) {
		ConciertoDTO concierto = new ConciertoDTO();	
		model.addAttribute("concierto", concierto);
		
		ArrayList<String> grupos = new ArrayList<>();	
		
		grupos.add("Estopa");
		grupos.add("Pereza");
		grupos.add("Skrilex");
		grupos.add("Raphael");
		grupos.add("Sabina");
		model.addAttribute("grupos", grupos);
		
		return "forms/concierto";
		
	}
	
	@PostMapping("/concierto")
	public String formConciertoPost(@ModelAttribute ConciertoDTO concierto, Model model) {
		model.addAttribute("concierto", concierto);
		return "forms/concierto";
		
	}
}
