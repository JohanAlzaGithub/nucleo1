package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.estudiante.Estudiante;
import com.example.demo.estudiante.EstudianteRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class EstudianteRepositoryTest {
	
	@Autowired
	private EstudianteRepository repositorio;
	
	@Test
	
	public void testCrearEstudiante() {
		
		Estudiante estudianteGuardado = repositorio.save(new Estudiante("Juan") );
		assertThat(estudianteGuardado.getId()).isGreaterThan(0);
		
	}
	
	

}
