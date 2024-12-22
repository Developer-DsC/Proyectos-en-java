package Programas;

public class Persona implements Comparable<Persona> {
	private String cedula;
	private String nombre;
	
	public Persona(String nombre, String cedula) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return cedula + "-" + nombre + "; ";
	}

	@Override
	public int compareTo(Persona p) {
		return this.cedula.compareTo(p.getCedula());
	}
}