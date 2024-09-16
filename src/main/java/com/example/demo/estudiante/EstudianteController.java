package com.example.demo.estudiante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteController {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@GetMapping("/estudiantes")
	public String listarEstudiantes(Model modelo) {
		List<Estudiante> listaEstudiantes = estudianteRepository.findAll();
		modelo.addAttribute("listaEstudiantes",listaEstudiantes);
		return "estudiantes";
		
		
	}
	
	@GetMapping("/estudiantes/nuevo")
	public String formularioNuevoEstudiante(Model modelo) {
		modelo.addAttribute("estudiante", new Estudiante());
		return "estudiante_formulario";
		
	}
	
	@PostMapping("/estudiantes/guardar")
	public String guardarEstudiante(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
		return "redirect:/estudiantes";
		
	}

}
