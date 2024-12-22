package algoritmos;

import tadLista.Lista;
import tadLista.NodoLista;

public class AlgoritmosListas<T> {

	protected NodoLista<T> inicio, fin;

	public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {
		lista.crearNodo();
		lista.asignarClave(dato);
	}
}