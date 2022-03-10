package org.iesalixar.servidor.controller;

import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profService;
	
	@GetMapping("/") 
	public String profesores(Model model) {
		
		model.addAttribute("profesores", profService.getAllTeachers());
		
		return "profesores";
	}
	
	@GetMapping("/asignaturas")
	public String profesorAsignaturas(@RequestParam(required=false, name="codigo") String codigo, Model model) {
		if(codigo==null) {
			return "redirect/profesores";
		}
		
		
		
		return "asignaturasProfesor";
	}
}
