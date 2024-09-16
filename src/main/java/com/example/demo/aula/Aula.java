package com.example.demo.aula;

import com.example.demo.estudiante.Estudiante;
import com.example.demo.profesor.Profesor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String numero;

	@OneToOne
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;

	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Aula(Integer id, String numero, Profesor profesor, Estudiante estudiante) {
		super();
		this.id = id;
		this.numero = numero;
		this.profesor = profesor;
		this.estudiante = estudiante;
	}

	public Aula() {
		super();
	}

	public Aula(String numero, Profesor profesor, Estudiante estudiante) {
		super();
		this.numero = numero;
		this.profesor = profesor;
		this.estudiante = estudiante;
	}

	public Aula(String numero) {
		super();
		this.numero = numero;
	}

}
