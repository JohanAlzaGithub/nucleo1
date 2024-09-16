package com.example.demo.aula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.estudiante.Estudiante;
import com.example.demo.estudiante.EstudianteRepository;
import com.example.demo.profesor.Profesor;
import com.example.demo.profesor.ProfesorRepository;

@Controller
public class AulaController {
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private ProfesorRepository profesorRepository;
	

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	
	@GetMapping("/aulas")
	public String listarAulas(Model modelo) {
		List<Aula> listaAulas = aulaRepository.findAll();
		modelo.addAttribute("listaAulas", listaAulas);
		return "aulas";
		
	}
	
	@GetMapping("/aulas/nuevo")
	public String formularioNuevaAula(Model modelo) {
		List<Profesor> listaProfesores = profesorRepository.findAll();
		List<Estudiante> listaEstudiantes = estudianteRepository.findAll();
		
		modelo.addAttribute("aula", new Aula());
		modelo.addAttribute("listaProfesores", listaProfesores);
		modelo.addAttribute("listaEstudiantes", listaEstudiantes);
		
		return "aula_formulario";
	}
	
		
	@PostMapping("/aulas/guardar")
	public String guardarEstudiante(Aula aula) {
		aulaRepository.save(aula);
		return "redirect:/aulas";
		
	}
	
	@GetMapping("/aulas/editar/{id}")
	public String formularioEditarEstudiante(@PathVariable("id") Integer id, Model modelo) {
		Aula aula = aulaRepository.findById(id).get();
		List<Profesor> listaProfesores = profesorRepository.findAll();
		List<Estudiante> listaEstudiantes = estudianteRepository.findAll();
		
		modelo.addAttribute("aula", aula);
		modelo.addAttribute("listaProfesores", listaProfesores);
		modelo.addAttribute("listaEstudiantes", listaEstudiantes);
		return "aula_formulario";
	}
	
	

}
