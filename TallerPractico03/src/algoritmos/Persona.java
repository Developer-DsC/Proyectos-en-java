package algoritmos;

public class Persona implements Comparable<Persona> {

	private String Cedula;
	private double peso;

	/**
	 * @param cedula
	 * @param peso
	 */

	public Persona(String cedula, double peso) {
		super();
		Cedula = cedula;
		this.peso = peso;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "persona [Cedula=" + Cedula + ", peso=" + peso + "]";
	}

	public int compareTo(Persona p) {
		if (this.peso > p.peso)
			return 1;
		else if (this.peso < p.peso)
			return -1;
		else
			return this.Cedula.compareTo(p.Cedula);
	}

}
