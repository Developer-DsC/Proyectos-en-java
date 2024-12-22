package algoritmos;

import arbolBinario.Arbol;
import arbolBinario.ArbolBB;
import arbolBinario.NodoArbol;

public class AlgoritmosArboles {
	public static <T extends Comparable<T>> void mostrarDatosEnOrden(Arbol<T> arbol) {
		ArbolBB<T> abb = new ArbolBB<T>();
		mostrarDatosEnOrden(arbol.getRaiz(), abb);
		abb.inOrder();
	}
	
	private static <T extends Comparable<T>> void mostrarDatosEnOrden(NodoArbol<T> arbol, ArbolBB<T> abb) {
		if(arbol!=null) {
			abb.insertar(arbol.getClave());
			mostrarDatosEnOrden(arbol.getIz(), abb);
			mostrarDatosEnOrden(arbol.getDe(), abb);
		}
	}
	
}
