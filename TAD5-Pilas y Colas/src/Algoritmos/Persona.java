package Algoritmos;

public class Persona implements Comparable<Persona> {

	private String cedula;
	private String nombre;
	private int edad;
	private double peso;

	public Persona(String cedula, String nombre, int edad, double peso) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}

	// Metodo comparable persona
	public int compareTo(Persona op) {
		if (this.getCedula().compareTo(op.getCedula()) != 0)
			return this.getCedula().compareTo(op.getCedula());
		else if (this.getEdad() == op.getEdad())
			return 0;
		else if (this.getEdad() > op.getEdad())
			return 1;
		else
			return -1;
	}
}
