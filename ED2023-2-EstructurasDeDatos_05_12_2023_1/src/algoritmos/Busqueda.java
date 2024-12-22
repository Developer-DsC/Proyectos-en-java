package algoritmos;

public class Busqueda {
	public static <T extends Comparable<T>> int busquedaBinaria(T dato, T[] vector) {
		int centro, inf = 0, sup = vector.length - 1;
		int resul = -1;
		while (inf <= sup) {
			centro = (inf + sup) / 2;
			if (vector[centro].compareTo(dato) == 0) {
				resul = centro;
				inf = sup + 1; // salida l�gica del lazo
			} else if (vector[centro].compareTo(dato) > 0)
				sup = centro - 1;
			else
				inf = centro + 1;
		}
		return resul;
	}

	public static <T extends Comparable<T>> int busquedaBinariaR(T dato, T[] vector) {
		return busquedaBinariaR(dato, vector, 0, 0);
	}

	public static <T extends Comparable<T>> int busquedaBinariaR(T dato, T[] vector, int inf, int sup) {
		int centro;
		int resul = -1;

		while (inf <= sup) {
			centro = (inf + sup) / 2;
			if (vector[centro].compareTo(dato) == 0) {
				resul = centro;
			} else {
				if (vector[centro].compareTo(dato) > 0)
					sup = centro - 1;
				else
					inf = centro + 1;
				resul = busquedaBinariaR(dato, vector, inf, sup);
			}
		}
		return resul;

	}

	public static <T extends Comparable<T>> int busquedaSecuencialR(T dato, T[] vector) {
		return busquedaSecuencialR(dato, vector, 0);

	}

	private static <T extends Comparable<T>> int busquedaSecuencialR(T dato, T[] vector, int pos) {
		if (pos >= vector.length) {
			return -1; // No se encontró el elemento
		}

		if (vector[pos].compareTo(dato) == 0) {
			return pos; // Elemento encontrado
		}

		return busquedaSecuencialR(dato, vector, pos + 1); // Llamada recursiva con la siguiente posición
	}

	public static <T extends Comparable<T>> int busquedaSecuencial(T dato, T[] vector) {
		int pos = 0, resul = -1;
		while (pos <= vector.length - 1) {
			if (vector[pos].compareTo(dato) == 0) {
				resul = pos;
				pos = vector.length; // salida l�gica del lazo
			}
			++pos;
		}
		return resul;
	}

}
