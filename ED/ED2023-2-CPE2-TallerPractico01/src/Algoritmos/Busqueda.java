package Algoritmos;

public class Busqueda {
	/*
	 * public static <T extends Comparable<T>> int busquedaBinaria(T dato, T[]
	 * vector) { int centro, inf = 0, sup = vector.length - 1; int resul = -1; while
	 * (inf <= sup) { centro = (inf + sup) / 2; if (vector[centro].compareTo(dato)
	 * == 0) { resul = centro; inf = sup + 1; // salida lógica del lazo } else if
	 * (vector[centro].compareTo(dato) > 0) sup = centro - 1; else inf = centro + 1;
	 * } return resul; }
	 * 
	 * // Debe estar ORDENADO el vector para hacer la búsqueda BINARIA.
	 * 
	 * 
	 * 
	 * public static <T extends Comparable<T>> int busquedaBinariaR(T dato, T[]
	 * vector) { return busquedaBinariaR(dato, vector, 0, vector.length - 1); }
	 * 
	 * private static <T extends Comparable<T>> int busquedaBinariaR(T dato, T[]
	 * vector, int inf, int sup) { int centro; int resul = -1;
	 * 
	 * if (inf <= sup) { centro = (inf + sup) / 2; if
	 * (vector[centro].compareTo(dato) == 0) { resul = centro; } else { if
	 * (vector[centro].compareTo(dato) > 0) sup = centro - 1; else inf = centro + 1;
	 * resul = busquedaBinariaR(dato, vector, inf, sup); } } return resul;
	 * 
	 * }
	 * 
	 * public static <T extends Comparable<T>> int busquedaSecuencial(T dato, T[]
	 * vector) { int pos = 0, resul = -1; while (pos <= vector.length - 1) { if
	 * (vector[pos].compareTo(dato) == 0) { resul = pos; pos = vector.length; //
	 * salida lógica del lazo } ++pos; } return resul; }
	 * 
	 * public static <T extends Comparable<T>> int busquedaSecuencialR(T dato, T[]
	 * vector) { return busquedaSecuencialR(dato, vector, 0); }
	 * 
	 * private static <T extends Comparable<T>> int busquedaSecuencialR(T dato, T[]
	 * vector, int pos) { int resul = -1; if (pos <= vector.length - 1) { if
	 * (vector[pos].compareTo(dato) == 0) resul = pos; else resul =
	 * busquedaSecuencialR(dato, vector, pos + 1); } return resul; }
	 */

	public static <T extends Comparable<T>> int busquedaSec(T a[], T clave) {
		int i = 0;
		while (i < a.length) {
			if (a[i].compareTo(clave) == 0)
				return i; // encontrado, devuelve posición
			else
				i++;
		}
		return -1; // elemento no encontrado
	}

	public static <T extends Comparable<T>> int busquedaBin(T[] a, T clave) {
		int central, bajo, alto;
		T valorCentral;
		bajo = 0;
		alto = a.length - 1;
		while (bajo <= alto) {
			central = (bajo + alto) / 2; // índice de elemento central
			valorCentral = a[central]; // valor del índice central
			if (clave.compareTo(valorCentral) == 0)
				return central; // encontrado, devuelve posición
			else if (clave.compareTo(valorCentral) < 0)
				alto = central - 1; // ir a sublista inferior
			else
				bajo = central + 1; // ir a sublista superior
		}
		return -1; // elemento no encontrado
	}

}