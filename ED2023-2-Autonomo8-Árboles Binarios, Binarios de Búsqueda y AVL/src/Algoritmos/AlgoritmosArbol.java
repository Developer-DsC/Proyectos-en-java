package Algoritmos;

import main.Persona;
import listaCalificadaOrdenada.Lista;
import tadarbolbinario.Arbol;
import tadarbolbinario.NodoArbol;

public class AlgoritmosArbol {

	public static <T extends Comparable<T>> void mostrarDatosEnOrden(Arbol<T> arbol) {
		Lista<T> lista = new Lista<T>("");
		mostrarDatosEnOrden(arbol.getRaiz(), lista);
		lista.imprimirLista();
	}

	private static <T extends Comparable<T>> void mostrarDatosEnOrden(NodoArbol<T> arbol, Lista<T> lista) {
		if (arbol != null) {
			lista.insertar(arbol.getClave());
			mostrarDatosEnOrden(arbol.getIz(), lista);
			mostrarDatosEnOrden(arbol.getDe(), lista);

		}
	}

	public static <T extends Comparable<T>> void modificarNodo(Arbol<T> arbol, T dato, T datoNuevo) {
		modificarNodo(arbol.getRaiz(), dato, datoNuevo);
	}

	private static <T extends Comparable<T>> void modificarNodo(NodoArbol<T> nodo, T dato, T datoNuevo) {
		if (nodo != null) {
			if (nodo.getClave().compareTo(dato) == 0) {
				nodo.setClave(datoNuevo);
			} else {
				modificarNodo(nodo.getIz(), dato, datoNuevo);
				modificarNodo(nodo.getDe(), dato, datoNuevo);
			}
		}
	}

	public static <T extends Comparable<T>> boolean modificarPorBusqueda(NodoArbol<Persona> arbol, String cedula,
			String cedula_nuevo) {
		boolean resul = false;
		if (arbol != null) {
			if (arbol.getClave().getCedula().compareTo(cedula) == 0) {

				if (arbol.getIz().getClave().getCedula().compareTo(cedula_nuevo) < 0
						&& arbol.getDe().getClave().getCedula().compareTo(cedula_nuevo) > 0) {
					arbol.getClave().setCedula(cedula_nuevo);
					resul = true;
				} else {
					resul = false;
				}
			} else {
				if (arbol.getClave().getCedula().compareTo(cedula) > 0) {
					resul = modificarPorBusqueda(arbol.getIz(), cedula, cedula_nuevo);

				} else {
					resul = modificarPorBusqueda(arbol.getDe(), cedula, cedula_nuevo);

				}

			}
		}
		return resul;
	}
}
