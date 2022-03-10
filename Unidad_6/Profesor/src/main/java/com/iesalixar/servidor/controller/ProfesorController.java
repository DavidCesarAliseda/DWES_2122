package com.iesalixar.servidor.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iesalixar.servidor.dto.ProfesorDTO;
import com.iesalixar.servidor.model.Profesor;
import com.iesalixar.servidor.service.ProfesorServiceImpl;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profesorService;

	@GetMapping("/")
	public String grados(Model model) {
		List<Profesor> profesores = profesorService.getAllProfesores();

		model.addAttribute("profesores", profesores);
		return "profesores";
	}

	@GetMapping("/asignaturas")
	public String asignaturasGrado(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "codigo") String codigo, Model model) {
		if (codigo == null) {
			return "redirect:/profesor/";
		}

		Optional<Profesor> profesor = profesorService.findProfesorById(Long.parseLong(codigo));
		model.addAttribute("profesor", profesor.get());

		if (profesor.get().getAsignaturas().size() == 0 || profesor == null) {
			error = "error";
			model.addAttribute("error", error);
		}
		return "profesorAsignaturas";
	}

	@GetMapping("/addProfesor")
	public String addProfesorGet(@RequestParam(required = false, name = "error") String error, Model model){

		ProfesorDTO profesor = new ProfesorDTO();
		model.addAttribute("profesor", profesor);
		model.addAttribute("error", error);

		return "addProfesor";

	}
	
	@PostMapping("/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profesor,Model model) {
		
		Date fecha = new Date();
		Profesor profesorBD = new Profesor();
		profesorBD.setNombre(profesor.getNombre());
		profesorBD.setNif(profesor.getNif());
		profesorBD.setApellido1(profesor.getApellido1());
		profesorBD.setApellido2(profesor.getApellido2());
		profesorBD.setCiudad(profesor.getCiudad());
		profesorBD.setDireccion(profesor.getDireccion());
		profesorBD.setFechaNacimiento(fecha);
		profesorBD.setSexo(profesor.getSexo());
		profesorBD.setTelefono(profesor.getTelefono());
		profesorBD.setDepartamento(null);
		
		
		if(profesorService.insertarProfesor(profesorBD)==null) {
			return "redirect:/profesor/addProfesor?error=Existe&profesor="+profesor.getApellido1();
		}

		return "redirect:/profesor/";

	}

}
