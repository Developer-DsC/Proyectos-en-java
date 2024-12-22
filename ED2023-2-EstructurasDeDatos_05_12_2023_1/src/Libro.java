import java.io.Serializable;

public class Libro implements Serializable {

	/**
	 * @author Dalton
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private int year; //Verificar los caracteres especiales 

	public Libro(String titulo, int year) {
		super();
		this.titulo = titulo;
		this.year = year;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "[titulo=" + titulo + ", year=" + year + "]";
	}

}