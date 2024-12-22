package Algoritmos;

public class Ordenacion {
	public static <T> void intercambiar(T[] a, int i, int j)
	{
		T aux = a[i];
		a[i] = a[j];
		a[j]= aux;
	}

	public static <T extends Comparable<T>> void ordBurbuja (T[] a)
	{
		int i, j;
		for (i = 0; i < a.length-1; i++)
			for(j = 0; j < a.length-i-1; j++)
				if(a[j+1].compareTo(a[j]) < 0)
					intercambiar(a, j, j+1);		
	}


	public static <T extends Comparable<T>> void ordSeleccion (T[] a)
	{
		int indiceMenor, i, j, n;
		n = a.length;
		for (i = 0; i < n-1; i++)
		{
			// comienzo de la exploración en índice i
			indiceMenor = i;
			// j explora la sublista a[i+1]..a[n-1]
			for (j = i+1; j < n; j++)
				if (a[j].compareTo(a[indiceMenor]) < 0)
					indiceMenor = j;
			// sitúa el elemento mas pequeño en a[i]
			if (i != indiceMenor)
				intercambiar(a, i, indiceMenor);
		}
	}

	public static <T extends Comparable<T>> void ordInsercion (T[] a)
	{
		int i, j;
		T aux;
		for (i = 1; i < a.length; i++)
		{
	/* índice j es para explorar la sublista a[i-1]..a[0] buscando la posición correcta del elemento destino*/
			j = i;
			aux = a[i];
	// se localiza el punto de inserción explorando hacia abajo
			while (j > 0 && aux.compareTo(a[j-1]) < 0)
			{
	// desplazar elementos hacia arriba para hacer espacio
				a[j] = a[j-1];
				j--;
			}
			a[j] = aux;
		}
	}

}