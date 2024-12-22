package tadLista;

public class NodoLista<T> {
	T clave;
	NodoLista<T> sig;
	NodoLista (T x, NodoLista<T> n) {
		clave = x;
		sig = n;
	}
	
	public static <T> void agregarEnMedio(Lista<T> lista, T datoAntesesor, T datoNuevo) {
		NodoLista<T> actual = lista.devolverReferencia();
		while (actual != null && !actual.clave.equals(datoAntesesor)) {
			actual = actual.sig;
		}
		if (actual != null) {
			NodoLista<T> nuevoNodo = new NodoLista<>(datoNuevo, actual.sig);
			actual.sig = nuevoNodo;
		} else {
			System.out.println("El dato antesesor no se encuentra en la lista.");
		}
	}
}

