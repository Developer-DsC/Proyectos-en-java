package algoritmos;

import arbolBinario.Arbol;
import arbolBinario.NodoArbol;
import listaCalificadaOrdenada.Lista;


public class AlgoritmosArbolesB {
	
	public static <T extends Comparable<T>> void mostrarDatosEnOrden(Arbol<T> arbol) {
		Lista<T> lista = new Lista<T>("Datos ordenados");
		mostrarDatosEnOrden(arbol.getRaiz(), lista);
		lista.imprimirLista();
	}
	
	private static <T extends Comparable<T>> void mostrarDatosEnOrden(NodoArbol<T> arbol, Lista<T> lista) {
		if(arbol!=null) {
			lista.insertar(arbol.getClave());
			mostrarDatosEnOrden(arbol.getIz(), lista);
			mostrarDatosEnOrden(arbol.getDe(), lista);
		}
	}
}
