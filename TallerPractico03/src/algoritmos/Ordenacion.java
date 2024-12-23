package algoritmos;

public class Ordenacion {
	private static <T> void intercambiar(T[] vector, int a, int b) {
		T aux;
		aux = vector[a];
		vector[a] = vector[b];
		vector[b] = aux;
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] vector) {
		for (int i = 0; i <= vector.length - 1; ++i)
			for (int j = 0; j <= vector.length - 2; ++j)
				if (vector[j].compareTo(vector[j + 1]) > 0) {
					intercambiar(vector, j, j + 1);
				}

	}

	public static <T extends Comparable<T>> void bubbleSortR(T[] vector) {
		bubbleSortR(vector, 0);
	}

	private static <T extends Comparable<T>> void bubbleSortR(T[] vector, int i) {
		boolean ordenado = true;
		if (i <= vector.length - 1) {
			for (int j = 0; j <= vector.length - 2; ++j)
				if (vector[j].compareTo(vector[j + 1]) > 0) {
					intercambiar(vector, j, j + 1);
					ordenado = false;
				}
			if (!ordenado)
				bubbleSortR(vector, i + 1);
		}

	}

	public static <T extends Comparable<T>> void seleccion(T[] vector) {
		int indiceMenor, i, j, n;
		n = vector.length;
		for (i = 0; i < n - 1; i++) {
			indiceMenor = i;
			for (j = i + 1; j < n; j++)
				if (vector[j].compareTo(vector[indiceMenor]) < 0)
					indiceMenor = j;
			if (i != indiceMenor)
				intercambiar(vector, i, indiceMenor);
		}
	}

	public static <T extends Comparable<T>> void seleccionR(T[] vector) {
		seleccionR(vector, 0);
	}

	private static <T extends Comparable<T>> void seleccionR(T[] vector, int i) {
		int indiceMenor, j, n;
		n = vector.length;
		if (i < n - 1) {
			indiceMenor = i;
			for (j = i + 1; j < n; j++)
				if (vector[j].compareTo(vector[indiceMenor]) < 0)
					indiceMenor = j;
			if (i != indiceMenor)
				intercambiar(vector, i, indiceMenor);
			seleccionR(vector, i + 1);
		}
	}

	public static <T extends Comparable<T>> void insercion(T[] vector) {
		int i, j;
		T aux;
		for (i = 1; i < vector.length; i++) {
			j = i;
			aux = vector[i];
			while (j > 0 && aux.compareTo(vector[j - 1]) < 0) {
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
		}
	}

	public static <T extends Comparable<T>> void insercionR(T[] vector) {
		insercionR(vector, 1);
	}

	private static <T extends Comparable<T>> void insercionR(T[] vector, int i) {
		int j;
		T aux;
		if (i < vector.length) {
			j = i;
			aux = vector[i];
			while (j > 0 && aux.compareTo(vector[j - 1]) < 0) {
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
			insercionR(vector, i + 1);
		}
	}

	public static <T extends Comparable<T>> void quickSort(T a[]) {
		quickSort(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T a[], int primero, int ultimo) {
		int i, j, central;
		T pivote;
		central = (primero + ultimo) / 2;
		pivote = a[central];
		i = primero;
		j = ultimo;
		do {
			while (a[i].compareTo(pivote) < 0)
				i++;
			while (a[j].compareTo(pivote) > 0)
				j--;
			if (i <= j) {
				intercambiar(a, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quickSort(a, primero, j);
		if (i < ultimo)
			quickSort(a, i, ultimo);
	}
}
