package tadLista;

public class NodoLista<T> {
	public T clave;
	public NodoLista<T> sig;
	NodoLista (T x, NodoLista<T> n) {
		clave = x;
		sig = n;
	}
}

