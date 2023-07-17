package es.cic.ejerc003;

public class AlumnoNoEncontradoException extends RuntimeException 
{
	public AlumnoNoEncontradoException() { }
	public AlumnoNoEncontradoException(String mensaje)
	{
		super(mensaje);
	}
	public AlumnoNoEncontradoException(String mensaje, Throwable th)
	{
		super(mensaje, th);
	}
}
