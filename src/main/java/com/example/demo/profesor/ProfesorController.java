package com.example.demo.profesor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
	@GetMapping("/profesores")
	public String listarProfesores(Model modelo) {
		List<Profesor> listaProfesores = profesorRepository.findAll();
		modelo.addAttribute("listaProfesores", listaProfesores);
		return "profesores";		
	}
	
	@GetMapping("/profesores/nuevo")
	public String formularioNuevoProfesor(Model modelo) {
		modelo.addAttribute("profesor", new Profesor());
		return "profesor_formulario";
	}
	
	@PostMapping("/profesores/guardar")
	public String guardarProfesor(Profesor profesor) {
		profesorRepository.save(profesor);
		return "redirect:/profesores";
	}
	
	

}
