public class Persona implements Comparable<Persona> {
	private String cedula;
	private int edad;

	public Persona(String cedula, int edad) {
		super();
		this.cedula = cedula;
		this.edad = edad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", edad=" + edad + "]";

	}

	@Override
	public int compareTo(Persona p) {
		return this.edad - p.getEdad();
	}
}