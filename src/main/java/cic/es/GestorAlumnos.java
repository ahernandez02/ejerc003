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
	public void editarAlumno(Alumno alumno, Alumno alumnoEditado)
	{
		int i = this.encontrarAlumno(alumno);
		if(i > -1)
		{
			this.alumnos[i].setNombre(alumnoEditado.getNombre());
			this.alumnos[i].setApellido(alumnoEditado.getApellido());
		}
	}
	public void eliminarAlumno(Alumno alumno)
	{
		int i = this.encontrarAlumno(alumno);
		if(i > -1)
		{
			this.alumnos[i] = null;
		}
	}
	private int encontrarAlumno(Alumno alumno)
	{
		int pos = -1;
		
		for(int i= 0; i < this.alumnos.length; i++)
		{
			if(this.alumnos[i] != null && 
					(this.alumnos[i].getNombre() == alumno.getNombre() && this.alumnos[i].getApellido() == alumno.getApellido() ))
			{
				pos = i;
			}
		}
		return pos;
	}
	
	
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	/*
	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}
	*/
	
}
