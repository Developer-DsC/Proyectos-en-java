package Algoritmos;

public class OrdenacionRecursiva {
	private static <T extends Comparable<T>> void intercambiar(T[] vector, int a, int b) {
		T aux;

		aux = vector[a];
		vector[a] = vector[b];
		vector[b] = aux;
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] vector) {
		//primer lazo para las pasadas
		//segundo lazo para las comparaciones por pasada
		for(int i=0; i<=vector.length-1; ++i)
			for(int j=0; j<=vector.length-2; ++j)
				if(vector[j].compareTo(vector[j+1]) > 0){
					intercambiar(vector, j, j+1);
				}	
	}
	
	public static <T extends Comparable<T>> void bubbleSortR(T[] vector) {
		bubbleSortR(vector,0);
	}
	
	private static <T extends Comparable<T>> void bubbleSortR(T[] vector,int i) {
		boolean ordenado = true;
		if(i<=vector.length-1) {
			for(int j=0; j<=vector.length-2; ++j)
				if(vector[j].compareTo(vector[j+1]) > 0){ 
					intercambiar(vector, j, j+1);
					ordenado = false;
				}
			if (!ordenado)
			bubbleSortR(vector, i+1);
	}
}

	public static <T extends Comparable<T>> void seleccion(T[] vector) {
		int indiceMenor, i, j, n;
		n = vector.length;
		for (i = 0; i < n - 1; i++) { // comienzo de la exploraci�n en �ndice i
			indiceMenor = i; // j explora la sublista a[i+1]..a[n-1]
			for (j = i + 1; j < n; j++)
				if (vector[j].compareTo(vector[indiceMenor])<0)
					indiceMenor = j; // situa el elemento mas pequeno en a[i]
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
		if(i < n - 1) { // comienzo de la exploración en índice i
			indiceMenor = i; // j explora la sublista a[i+1]..a[n-1]
			for (j = i + 1; j < n; j++)
				if (vector[j].compareTo(vector[indiceMenor]) < 0)
					indiceMenor = j; // sitúa el elemento mas pequeño en a[i]
			if (i != indiceMenor)
				intercambiar(vector, i, indiceMenor);
			seleccionR(vector, i+1);
		}
	}

	public static <T extends Comparable<T>> void insercion(T[] vector) {
		int i, j;
		T aux;
		for (i = 1; i < vector.length; i++) {
			/*
			 * �ndice j es para explorar la sublista a[i-1]..a[0] buscando la posici�n
			 * correcta del elemento destino
			 */
			j = i;
			aux = vector[i];
			// se localiza el punto de inserci�n explorando hacia abajo
			while (j > 0 && aux.compareTo(vector[j - 1])<0) {
				// desplazar elementos hacia arriba para hacer espacio
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
		if(i < vector.length) {
			/*
			 * índice j es para explorar la sublista a[i-1]..a[0] buscando la posición
			 * correcta del elemento destino
			 */
			j = i;
			aux = vector[i];
			// se localiza el punto de inserción explorando hacia abajo
			while (j > 0 && aux.compareTo(vector[j - 1]) < 0) {
				// desplazar elementos hacia arriba para hacer espacio
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
			insercionR(vector, i+1);
		}
	}

	public static  <T extends Comparable<T>> void quickSort(T vector[]) {
		quickSort(vector, 0, vector.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T vector[], int primero, int ultimo) {
		int i, j, central;
		T pivote;
		central = (primero + ultimo) / 2;
		pivote = vector[central];
		i = primero;
		j = ultimo;
		do {
			while (vector[i].compareTo(pivote) < 0)
				i++;
			while (vector[j].compareTo(pivote) > 0)
				j--;
			if (i <= j) {
				intercambiar(vector, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quickSort(vector, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			quickSort(vector, i, ultimo); // mismo proceso con sublista drcha
	}
}