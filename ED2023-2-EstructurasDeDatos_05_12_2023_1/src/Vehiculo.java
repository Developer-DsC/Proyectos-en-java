import java.io.Serializable;

public class Vehiculo implements Comparable<Vehiculo>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placa;

	public Vehiculo(String placa) {
		super();
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + "]";
	}

	@Override
	public int compareTo(Vehiculo v) {
		// TODO Auto-generated method stub
		return this.placa.compareTo(placa+1);
	}
}