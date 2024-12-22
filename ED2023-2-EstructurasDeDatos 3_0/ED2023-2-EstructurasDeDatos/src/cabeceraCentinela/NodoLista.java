package cabeceraCentinela;

import java.io.Serializable;

public class NodoLista<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	T clave;	
	NodoLista<T> sig;
	
	NodoLista (T dato) {
		clave = dato;
		sig = null;
	}
	
	public T getClave() {
		return clave;
	}
	
	/**
	 * @return the sig
	 */
	public NodoLista<T> getSig() {
		return sig;
	}
	
}

