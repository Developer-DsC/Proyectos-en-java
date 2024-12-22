package tallerCola;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Simulacion {
	public static void main(String[] args) {
		try {
			simulacion(3600, 5);
		} catch (ColaVacia e) {
			System.out.println(e.getMessage());
		} // simular 3600 segundos a 5 páginas/min
	}

	private static void simulacion(int numeroSegundos, int paginasPorMinuto) throws ColaVacia {
		// TODO Auto-generated method stub
		Impresora impresoraLaboratorio = new Impresora(paginasPorMinuto);

		Cola<Integer> tiempoEspera = new TadCola<>();
		Cola<Tarea> colaImpresion = new TadCola<>();

		Tarea tarea, tareaSiguiente;

		int esperaPromedio = 0, n;

		for (int segundoActual = 0; segundoActual < numeroSegundos;

				segundoActual++) {

			if (nuevaTareaImpresion()) {
				tarea = new Tarea(segundoActual);
				colaImpresion.encolar(tarea);
			}
			if (!impresoraLaboratorio.ocupada() && !colaImpresion.colaVacia()) {
				tareaSiguiente = colaImpresion.desencolar();
				impresoraLaboratorio.iniciarNueva(tareaSiguiente);
				tiempoEspera.encolar(tareaSiguiente.tiempoEspera(segundoActual));
			}
			impresoraLaboratorio.tictac();

		}

		n = tiempoEspera.numElemCola();
		for (int i = 0; i < tiempoEspera.numElemCola(); i++) {
			esperaPromedio += tiempoEspera.desencolar();
		}
		esperaPromedio = esperaPromedio / n;
		System.out.println(" tiempo de espera promedio "+esperaPromedio +" segundos "+  colaImpresion.numElemCola()+ " tareas restantes ");
	}

	public static boolean nuevaTareaImpresion() {
		int numero = (int) (Math.random() * 180 + 1);
		if (numero == 180) {
			return true;
		} else {
			return false;
		}

	}
}
