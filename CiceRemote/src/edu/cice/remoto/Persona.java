package edu.cice.remoto;

public class Persona {
public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
String nombre;
int edad;
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre ="+nombre+" Edad = "+edad;
	}
}
