package exercisesXML;

import java.io.Serializable;

public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7680749070435547716L;
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	private int edad;
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	

}
