package defaults;

public class Persona implements Comparable<Persona> {
	private String cedula;
	private int peso;
	
	public Persona(String cedula, int peso) {
		super();
		this.cedula = cedula;
		this.peso = peso;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", peso=" + peso + "]";
	}

	@Override
	public int compareTo(Persona p) {
		if(this.peso < p.getPeso())
			return -1;
		else
			if(this.peso > p.getPeso())
				return 1;
			else
				return this.cedula.compareTo(p.getCedula());
	}	
}