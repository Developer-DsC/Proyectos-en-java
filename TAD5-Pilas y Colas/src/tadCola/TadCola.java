package tadCola;

public class TadCola<T> implements Cola<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	private NodoCola<T> principio;
	private NodoCola<T> fin;

	public TadCola() {
		nombre = "";
		principio = null;
		fin = null;
	}

	public TadCola(String nombre) {
		this.nombre = nombre;
		principio = null;
		fin = null;
	}

	public boolean colaVacia() {
		return principio == null;
	}

	public void eliminarCola() {
		principio = null;
		fin = null;
	}

	public T primero() throws ColaVacia {
		if (colaVacia())
			throw new ColaVacia("La cola esta vacia");
		return principio.dato;
	}

	public void encolar(T x) {
		NodoCola<T> aux;
		aux = new NodoCola<T>(x, null);
		if (principio == null) {
			principio = aux;
			fin = aux;
		} else {
			fin.siguiente = aux;
			fin = aux;
		}
	}

	public T desencolar() throws ColaVacia {
		T resultado;
		if (colaVacia()) {
			throw new ColaVacia("Desencolar: La cola esta vacia");
		}
		resultado = principio.dato;
		principio = principio.siguiente;
		if (principio == null)
			fin = null;
		return resultado;

	}

	public void quitarPrimero() throws ColaVacia {
		if (colaVacia()) {
			throw new ColaVacia("Quitar primero: La cola esta vacia");
		}
		principio = principio.siguiente;
		if (principio == null)
			fin = null;
	}

	public void mostrarEstadoCola() {
		System.out.println("Estado de la cola:");
		System.out.println("N�mero de elementos: " + this.numElemCola());
		if (!colaVacia()) {
			System.out.println("Primer elemento - Clave: " + principio.dato);
			System.out.println("�ltimo elemento - Clave: " + fin.dato);
		}
	}

	public void imprimirCola() {
		NodoCola<T> aux;
		System.out.print("Estado de la cola: ");
		aux = principio;
		while (aux != null) {
			System.out.println(aux.dato + " ");
			aux = aux.siguiente;
		}
		System.out.println();
	}

	public int numElemCola() {
		NodoCola<T> aux;
		int resul;

		aux = principio;
		resul = 0;
		while (aux != null) {
			++resul;
			aux = aux.siguiente;
		}
		return resul;
	}

	public void invertirCola() throws ColaVacia {
		T elem;
		if (!colaVacia()) {
			elem = desencolar();
			invertirCola();
			encolar(elem);
		}
	}

	// Metodo para ver el numero mayor de la cola
	public static <T extends Comparable<T>> T verMayorCola(Cola<T> cola) throws ColaVacia {
		return verMayorColaR(cola, cola.primero());
	}

	// Metodo recursivo para ver el numero mayor de la cola
	static <T extends Comparable<T>> T verMayorColaR(Cola<T> cola, T mayor) throws ColaVacia {
		T elem;
		if (!cola.colaVacia()) {
			elem = cola.desencolar();
			if (elem.compareTo(mayor) > 0)
				mayor = elem;
			mayor = verMayorColaR(cola, mayor);
			cola.encolar(elem);
		}
		return mayor;
	}

	// Metodo para ver el numero menor de la cola
	public static <T extends Comparable<T>> T verMenorCola(Cola<T> cola) throws ColaVacia {
		return verMenorColaR(cola, cola.primero());
	}

	// Metodo recursivo para ver el numero menor de la cola
	static <T extends Comparable<T>> T verMenorColaR(Cola<T> cola, T menor) throws ColaVacia {
		T elem;
		if (!cola.colaVacia()) {
			elem = cola.desencolar();
			if (elem.compareTo(menor) < 0)
				menor = elem;
			menor = verMenorColaR(cola, menor);
			cola.encolar(elem);
		}
		return menor;
	}

	// Implementacion de un metodo booleano que localice un elemento en una cola
	// generica
	public static <T extends Comparable<T>> boolean buscarDatoCola(Cola<T> cola, T dato) throws ColaVacia {
		cola.invertirCola();
		return buscarDatoColaR(cola, dato);
	}

	// Implementacion de un metodo booleano recursivo que localice un elemento en
	// una cola generica
	public static <T extends Comparable<T>> boolean buscarDatoColaR(Cola<T> cola, T dato) throws ColaVacia {
		boolean resul;
		T elem;
		if (!cola.colaVacia()) {
			elem = cola.desencolar();
			if (elem.compareTo(dato) == 0) {
				resul = true;
				cola.invertirCola();
			} else
				resul = buscarDatoColaR(cola, dato);
			cola.encolar(elem);
		} else
			resul = false;
		return resul;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	// Metodo recursivo Final Cola
	public static <T> T verFinalCola(Cola<T> cola) throws ColaVacia {
		if (cola.colaVacia()) {
			throw new ColaVacia("La cola está vacía");
		}

		T finalCola = null;
		if (!cola.colaVacia()) {
			finalCola = cola.desencolar();
			finalCola = verFinalColaR(cola, finalCola);
		}
		cola.encolar(finalCola);

		return finalCola;
	}

	private static <T> T verFinalColaR(Cola<T> cola, T finalCola) throws ColaVacia {
		if (!cola.colaVacia()) {
			T dato = cola.desencolar();
			finalCola = verFinalColaR(cola, dato);
			cola.encolar(dato);
		}
		return finalCola;
	}

}
