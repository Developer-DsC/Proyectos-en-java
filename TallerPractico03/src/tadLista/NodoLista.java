package tadLista;
/**
 * @autor Dalton
 */
public class NodoLista<T> {

	private T clave;
	private NodoLista<T> sig;
	public NodoLista(T x, NodoLista<T> n) {
		clave = x;
		sig = n;
	}

	public T getClave() {
		return clave;
	}

	public NodoLista<T> getSig() {
		return sig;
	}

	public void setClave(T clave) {
		this.clave = clave;
	}

	public void setSig(NodoLista<T> sig) {
		this.sig = sig;
	}

}