package es.cic.ejerc003;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class GestorAlumnos 
{
	
	private Alumno[] alumnos;
	
	public GestorAlumnos()
	{
		this.alumnos = new Alumno[10];
	}

	public void add(Alumno alumno)
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
	public void update(Alumno alumno, Alumno alumnoEditado) throws AlumnoNoEncontradoException
	{
		int i = this.get(alumno);
		this.alumnos[i] = alumnoEditado;
	}
	public void delete(Alumno alumno) throws AlumnoNoEncontradoException 
	{
		int i = this.get(alumno);
		this.alumnos[i] = null;
	}
	public String visualizar()
	{
		//Crear fichero en directorio temporal que contenga archivo con contenido del
		//listado de alumnos
		String path = "";
		try 
		{
			File f = File.createTempFile("alumnos",".txt");
			FileWriter fw = new FileWriter(f);
			for (int i = 0; i < alumnos.length; i++) 
			{
				if(this.alumnos[i] == null) continue;
				fw.write(this.alumnos[i].getNombre() + " " + this.alumnos[i].getApellido() + "\n");
			}
			fw.close();
			path = f.getPath();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return path;
	}
	
	private int get(Alumno alumno) throws AlumnoNoEncontradoException
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
			throw new AlumnoNoEncontradoException("El alumno no existe");
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