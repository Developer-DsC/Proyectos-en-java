import java.io.Serializable;

public class Libro implements Comparable<Libro>, Serializable {
	private static final long serialVersionUID = 1L;
	private String titulo;
	private int year;
	
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

	@Override
	public String toString() {
		return titulo + "-" + year;
	}

	@Override
	public int compareTo(Libro libro) {
		if(this.year > libro.getYear())
			return 1;
		else
			if(this.year < libro.getYear())
				return -1;
			else
				return this.titulo.compareTo(libro.getTitulo());
	}

	
	

}
