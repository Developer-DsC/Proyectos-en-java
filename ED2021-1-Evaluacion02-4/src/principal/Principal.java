package principal;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Principal {
	/**
	 * Método main para la prueba. NO MODIFICAR
	 * 
	 * @param args
	 * @throws ColaVacia 
	 */
	public static void main(String[] args) throws ColaVacia {
		Cola<Integer> cola = new TadCola<>("Números");
		Integer dato = 25;
		int pos = 1;
		boolean resul;

		// prueba cola
		for (int i = 1; i <= 10; ++i)
			cola.encolar(i);
		cola.imprimirCola();
		System.out.println("Ingreso de dato: " + dato + ", en pos: " + pos);
		resul = addElement(cola, dato, pos);
		System.out.println(resul ? "Ingreso exitoso" : "Ingreso incorrecto");
		cola.imprimirCola();

	}

	public static <T> boolean addElement(Cola<T> cola, T dato, int pos) throws ColaVacia {
		if (pos <= 0 || pos > cola.numElemCola()+1) {
			return false;
		} else {
			addElementR(cola, dato, pos-1);
			cola.invertirCola();
			return true;
		}
	}

	private static <T> void addElementR(Cola<T> cola, T dato, int pos) throws ColaVacia {
		if (pos > 0) {
			if (!cola.colaVacia()) {
				T elemento = cola.desencolar();
				addElementR(cola, dato, pos - 1);
				cola.encolar(elemento);
			}else {
				cola.encolar(dato);
			}
		} else {
			cola.invertirCola();
			cola.encolar(dato);
		}
	}
}