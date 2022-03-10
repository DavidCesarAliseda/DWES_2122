package org.iesalixar.servidor.controller;

import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.models.Grado;
import org.iesalixar.servidor.services.GradosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/grados")
public class GradosController {

	@Autowired
	GradosServiceImpl gradoService;

	@GetMapping("/")
	public String grados(Model model) {
		List<Grado> grados = gradoService.getAllGrados();
		
		
		model.addAttribute("grados", grados);
		return "grados";
	}

	@GetMapping("/asignaturas")
	public String asignaturasGrado(@RequestParam(required=false,name="error")String error, @RequestParam(required=false,name="codigo")String codigo,Model model) {
		if (codigo==null ) {
			return "redirect:/grados/";
		}
	
		Optional<Grado> grado = gradoService.findGradoById(Long.parseLong(codigo));
		model.addAttribute("grado",grado.get());		
		
		if(grado.get().getAsignatura().size() == 0 || grado == null) {
			error="error";
			model.addAttribute("error",error);	
		}
		return "gradoAsignaturas";
	}
	
	@GetMapping("/addGrado")
	public String addGradoGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {
		
		GradoDTO grado = new GradoDTO();
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		return "addGrado";
	}
	
	@PostMapping("/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO grado,Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(grado.getNombre());
		
		if (gradoService.insertarGrado(gradoBD)==null) {
			return "redirect:/grados/addGrado?error=Existe&grado="+grado.getNombre();
		}
		
		return "redirect:/grados/";
	}
}
