package es.cic.ejerc003;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorAlumnosIntegrationTest {

	private GestorAlumnos cut;

	@BeforeEach
	void setUp() throws Exception 
	{
	  cut = new GestorAlumnos();
	}

	@Test
	void testAnadirAlumno() 
	{
		Alumno alumno = new Alumno("Primer", "Alumno");
		
		cut.anadirAlumno(alumno);
		
		Alumno[] expectedAlumnos = new Alumno[10];
		expectedAlumnos[0] = alumno;
		
		assertArrayEquals(cut.getAlumnos(), expectedAlumnos);
	}

	@Test
	void testEditarAlumno() throws Exception 
	{
		Alumno alumno = new Alumno("Primer", "Alumno");
		cut.anadirAlumno(alumno);
		
		Alumno alumnoEditado = new Alumno("Primer", "AlumnoEditado");
		cut.editarAlumno(alumno, alumnoEditado);
		
		Alumno[] expectedAlumnos = new Alumno[10];
		expectedAlumnos[0] = alumnoEditado;
	
		assertArrayEquals(cut.getAlumnos(), expectedAlumnos);
	}

	@Test
	void testEliminarAlumno() throws Exception 
	{
		Alumno alumno = new Alumno("Primer", "Alumno");
		cut.anadirAlumno(alumno);
		cut.eliminarAlumno(alumno);
		
		Alumno[] expectedAlumnos = new Alumno[10];
		expectedAlumnos[0] = null;
		
		assertArrayEquals(cut.getAlumnos(), expectedAlumnos);
	}

}