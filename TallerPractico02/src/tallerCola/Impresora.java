package tallerCola;

public class Impresora {
	private int tasaPaginas;
	private int tiempoRestante;
	Tarea tareaActual;

	public Impresora() {
		super();
	}

	public Impresora(int paginas) {
		super();
		this.tasaPaginas = paginas;
		this.tareaActual = null;
		this.tiempoRestante = 0;

	}

	public void tictac() {
		if (this.tareaActual != null) {
			this.tiempoRestante = this.tiempoRestante - 1;
			if (this.tiempoRestante == 0) {
				this.tareaActual = null;

			}

		}
	}

	public boolean ocupada() {
		if (this.tareaActual != null) {
			return true;
		} else {
			return false;
		}
	}
	public void iniciarNueva(Tarea nuevaTarea) {
		this.tareaActual = nuevaTarea;
		this.tiempoRestante = tasaPaginas*tareaActual.obtenerPaginas(); // Cálculo de tiempo requerido por tarea
	}

}
