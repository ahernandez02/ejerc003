package cic.es;

import java.util.Iterator;

public class GestorAlumnos 
{
	
	private Alumno[] alumnos;
	
	public GestorAlumnos()
	{
		this.alumnos = new Alumno[10];
	}

	public void anadirAlumno(Alumno alumno)
	{
		for(int i = 0; i < alumnos.length; i++)
		{
			if(alumnos[i] == null)
			{
				alumnos[i] = alumno;
				break;
			}
		}		
	}
	public void editarAlumno(Alumno alumno, Alumno alumnoEditado) throws Exception
	{
		int i = this.encontrarAlumno(alumno);
		this.alumnos[i] = alumnoEditado;
	}
	public void eliminarAlumno(Alumno alumno) throws Exception 
	{
		int i = this.encontrarAlumno(alumno);
		this.alumnos[i] = null;
	}
	private int encontrarAlumno(Alumno alumno) throws Exception
	{
		int pos = -1;
		
		for(int i= 0; i < this.alumnos.length; i++)
		{
			if(this.alumnos[i] == null)
				continue;
			
			if(this.alumnos[i].hashCode() == alumno.hashCode())
				pos = i;
		}
		if(pos == -1)
		{
			throw new Exception("El alumno no existe");
		}
		return pos;
	}
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}
	
}
