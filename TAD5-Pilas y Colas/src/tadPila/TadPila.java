package tadPila;

public class TadPila<T extends Comparable<T>> implements Pila<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NodoPila<T> pila;
	String Nombre;

	public TadPila() {
		pila = null;
		Nombre = "";
	}

	public TadPila(String nombre) {
		this.pila = null;
		Nombre = nombre;
	}

	public boolean pilaVacia() {
		return pila == null;
	}

	public void eliminarPila() {
		pila = null;
	}

	public T cima() throws PilaVacia {
		if (pilaVacia())
			throw new PilaVacia("La pila est� vac�a");
		return pila.dato;
	}

	public void apilar(T dato) {
		NodoPila<T> aux;
		aux = new NodoPila<>(dato, pila);
		pila = aux;
	}

	public T desapilar() throws PilaVacia {
		T resultado;
		if (pilaVacia()) {
			throw new PilaVacia("Desapilar: La pila est� vac�a");
		}
		resultado = pila.dato;
		pila = pila.siguiente;
		return resultado;
	}

	public void decapitar() throws PilaVacia {
		if (pilaVacia())
			throw new PilaVacia("Decapitar: La pila est� vac�a");
		pila = pila.siguiente;

	}

	public void imprimirPila() {
		NodoPila<T> aux;
		System.out.print("Estado de la pila: ");
		aux = pila;
		while (aux != null) {
			System.out.println(aux.dato.toString() + " ");
			aux = aux.siguiente;
		}
		System.out.println();
	}

	public int numElemPila() {
		NodoPila<T> aux;
		int resul;

		aux = pila;
		resul = 0;
		while (aux != null) {
			++resul;
			aux = aux.siguiente;
		}
		return resul;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	// Metodo para ver el numero mayor de la pila
	public static <T extends Comparable<T>> T verMayorPila(Pila<T> pila) throws PilaVacia {
		return verMayorPilaR(pila, pila.cima());
	}
	// Metodo recursivo para ver el numero mayor de la pila

	public static <T extends Comparable<T>> T verMayorPilaR(Pila<T> pila, T mayor) throws PilaVacia {
		T dato = null;
		if (!pila.pilaVacia()) {
			dato = pila.desapilar();
			if (dato.compareTo(mayor) > 0)
				mayor = dato;
			mayor = verMayorPilaR(pila, mayor);
			pila.apilar(dato);
		}
		return mayor;
	}

	// Metodo para ver el numero menor de la pila
	public static <T extends Comparable<T>> T verMenorPila(Pila<T> pila) throws PilaVacia {
		return verMenorPilaR(pila, pila.cima());
	}

	// Metodo recursivo para ver el numero menor de la pila
	private static <T extends Comparable<T>> T verMenorPilaR(Pila<T> pila, T menor) throws PilaVacia {
		T dato = null;
		if (!pila.pilaVacia()) {
			dato = pila.desapilar();
			if (dato.compareTo(menor) < 0)
				menor = dato;
			menor = verMenorPilaR(pila, menor);
			pila.apilar(dato);
		}
		return menor;
	}

	// Implementacion de un metodo booleano que localice un elemento en una pila
	// generica
	public static <T extends Comparable<T>> boolean buscarDatoPila(Pila<T> pila, T dato) throws PilaVacia {
		return buscarDatoPilaR(pila, dato);
	}

	// Implementacion de un metodo booleano recursivo que localice un elemento en
	// una pila generica
	private static <T extends Comparable<T>> boolean buscarDatoPilaR(Pila<T> pila, T dato) throws PilaVacia {
		boolean resul;
		T elem;
		if (!pila.pilaVacia()) {
			elem = pila.desapilar();
			if (elem.compareTo(dato) == 0) {
				resul = true;
			} else
				resul = buscarDatoPilaR(pila, dato);
			pila.apilar(elem);
		} else
			resul = false;
		return resul;
	}

	// Metodo recursivo para ver el fondo de la pila
	public static <T extends Comparable<T>> T verFondoPila(Pila<T> pila) throws PilaVacia {
		if (pila.pilaVacia()) {
			throw new PilaVacia("La pila está vacía");
		}

		T fondo = verFondoPilaR(pila, pila.desapilar());
		pila.apilar(fondo);

		return fondo;
	}

	private static <T extends Comparable<T>> T verFondoPilaR(Pila<T> pila, T fondo) throws PilaVacia {
		if (!pila.pilaVacia()) {
			T dato = pila.desapilar();
			fondo = verFondoPilaR(pila, dato);
			pila.apilar(dato);
		}
		return fondo;
	}

}