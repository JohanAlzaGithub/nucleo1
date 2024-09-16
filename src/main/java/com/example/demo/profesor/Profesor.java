package com.example.demo.profesor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profesor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private String materia;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Profesor() {
		super();
	}
	public Profesor(Integer id, String nombre, String apellido, String materia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.materia = materia;
	}
	public Profesor(Integer id) {
		super();
		this.id = id;
	}
	public Profesor(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
}
