package es.cic.ejerc003;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorAlumnosTest {

	private GestorAlumnos cut;

	@BeforeEach
	void setUp() throws Exception 
	{
	  cut = new GestorAlumnos();
	}

	@Test
	void testAdd() 
	{
		Alumno alumno = new Alumno("Primer", "Alumno");
		
		cut.add(alumno);
		
		Alumno[] expectedAlumnos = new Alumno[10];
		expectedAlumnos[0] = alumno;
		
		assertArrayEquals(cut.getAlumnos(), expectedAlumnos);
	}

	@Test
	void testUpdate() throws AlumnoNoEncontradoException 
	{
		Alumno alumno = new Alumno("Primer", "Alumno");
		cut.add(alumno);
		
		Alumno alumnoEditado = new Alumno("Primer", "AlumnoEditado");
		cut.update(alumno, alumnoEditado);
		
		Alumno[] expectedAlumnos = new Alumno[10];
		expectedAlumnos[0] = alumnoEditado;
	
		assertArrayEquals(cut.getAlumnos(), expectedAlumnos);
	}

	@Test
	void testDelete() throws AlumnoNoEncontradoException 
	{
		Alumno alumno = new Alumno("Primer", "Alumno");
		cut.add(alumno);
		cut.delete(alumno);
		
		Alumno[] expectedAlumnos = new Alumno[10];
		expectedAlumnos[0] = null;
		
		assertArrayEquals(cut.getAlumnos(), expectedAlumnos);
	}
	@Test
	void testVisualizar() throws IOException
	{
		cut.add(new Alumno("Primer", "Alumno"));
		cut.add(new Alumno("Segundo", "Alumno"));
		cut.add(new Alumno("Tercer", "Alumno"));
		
		String path = cut.visualizar();
		FileInputStream fis = new FileInputStream(path);
		int bytesCount = fis.available();
		
		assertNotEquals(bytesCount, 0);
	}

}