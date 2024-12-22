package doblementeEnlazadasOrdenadas;

import java.io.Serializable;

public class NodoLista<T extends Comparable<T>> implements Serializable {
	private static final long serialVersionUID = 1L;

    public T clave;
    public NodoLista<T> sig, ant;

    public NodoLista(T x) {
        clave = x;
        sig = null;
        ant = null;
    }
}
