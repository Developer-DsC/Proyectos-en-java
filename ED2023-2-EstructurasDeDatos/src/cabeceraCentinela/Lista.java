package cabeceraCentinela;

import java.io.Serializable;

public class Lista<T extends Comparable<T>> implements Serializable {
	private static final long serialVersionUID = 1L;
	private NodoLista<T> cab, cent;
	private String nombre;
	
	public Lista() {
		cab = new NodoLista<>(null);
		cent = new NodoLista<>(null);
		cab.sig = cent;
	}
	
	public Lista(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public NodoLista<T> getCab() {
		return cab;
	}

	public NodoLista<T> getCent() {
		return cent;
	}

	public boolean busqueda (T dato) {
		NodoLista<T> anterior, actual;
		boolean resul = false;
	 
		anterior = cab;
		actual = anterior.sig;
		cent.clave = dato;
		while (actual.clave.compareTo(dato) < 0) {
			anterior = actual;
			actual = actual.sig;
		}
		if ((actual != cent) && (actual.clave.compareTo(dato) == 0))
			resul = true;
		return resul;
	}
	
	public void insertar (T dato) {
		NodoLista<T> anterior, actual, aux;

		anterior = cab;
		actual = anterior.sig;
		cent.clave = dato;
		while (actual.clave.compareTo(dato) < 0) {
			anterior = actual;
			actual = actual.sig;
		}
		if ((actual.clave.compareTo(dato) > 0) || (actual == cent)) {
			aux = new NodoLista<>(dato);
			aux.sig = actual;
			anterior.sig = aux;
		}
		else System.out.println ("Error, el elemento está repetido");
	}
	
	public void eliminar (T dato) {
		NodoLista<T> anterior, actual;

		anterior = cab;
		actual = anterior.sig;
		cent.clave = dato;
		while (actual.clave.compareTo(dato) < 0) {
			anterior = actual;
			actual = actual.sig;
		}
		if ((actual == cent) || (actual.clave.compareTo(dato) > 0))
			System.out.println ("Error, elemento inexistente");
		else anterior.sig = actual.sig;
	}
	
	public void imprimirLista () {
	 	NodoLista<T> actual;

		actual = cab.sig;
		while (actual != cent) {
			System.out.print (actual.clave + " ");
			actual = actual.sig;
		}
		System.out.println ("FIN");
	}
	
	@Override
	public String toString() {
		return nombre + ": " + stringDeLista();
	}
	
	private String stringDeLista() {
		StringBuffer cadena = new StringBuffer();
		NodoLista<T> actual = cab.sig;
		while(actual!=cent) {
			cadena.append(actual.clave.toString());
			cadena.append(" ");
			actual = actual.sig;
		}
		cadena.append("FIN");
		return cadena.toString();
	}

}
