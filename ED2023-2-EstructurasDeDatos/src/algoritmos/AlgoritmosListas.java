package algoritmos;

import tadLista.Lista;
import tadLista.TadLista;

public class AlgoritmosListas {

	public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {
		if(lista!=null) {
			lista.crearNodo();
			lista.asignarClave(dato);
		}
	}
	
	public static <T> int contar(Lista<T> lista) {

		if(lista!=null) {
			Lista<T> aux = new TadLista<>();
			aux.asignarReferencia(lista.devolverReferencia());
			return contarR(aux);
		} else
			return -1;

	}
	
	private static <T> int contarR(Lista<T> aux) {
		int resul;
		
		if(!aux.esNulo()) {
			aux.asignarReferencia(aux.devolverSiguiente());
			resul = 1 + contarR(aux);
		}
		else
			resul = 0;		
		return resul;
	}
	
	public static <T> void eliminarPrimero(Lista<T> lista) {
		if(lista!=null && !lista.esNulo())
			lista.asignarReferencia(lista.devolverSiguiente());
	}
	
	public static <T> void insertarAlFinal(Lista<T> lista, T dato) {
		if(lista!=null) {
			if(!lista.esNulo()) {
				Lista<T> aux = new TadLista<>();
				aux.asignarReferencia(lista.devolverReferencia());
				insertarAlFinalR(aux, dato);
			} else
				insertarAlPrincipio(lista, dato);
		}
	}
	
	private static <T> void insertarAlFinalR(Lista<T> aux, T dato) {
		if(aux.devolverSiguiente() == null) {
			Lista<T> aux2 = new TadLista<>();
			insertarAlPrincipio(aux2, dato);
			aux.asignarReferenciaSiguiente(aux2.devolverReferencia());
		}
		else {
			aux.asignarReferencia(aux.devolverSiguiente());
			insertarAlFinalR(aux, dato);
		}
	}
	
	public static <T> void duplicarLista1(Lista<T> listaO, Lista<T> listaD) {
		if(listaO != null && listaD != null) {
			Lista<T> aux = new TadLista<>();
			aux.asignarReferencia(listaO.devolverReferencia());
			listaD.asignarNulo();
			duplicarLista1R(aux, listaD);
		}
	}
	
	private static <T> void duplicarLista1R(Lista<T> aux, Lista<T> listaD) {
		if(!aux.esNulo()) {
			insertarAlFinal(listaD, aux.devolverClave());
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista1R(aux, listaD);
		}
	}
	
	public static <T> void duplicarLista2(Lista<T> listaO, Lista<T> listaD) {
		if(listaO != null && listaD != null) {
			Lista<T> aux = new TadLista<>();
			aux.asignarReferencia(listaO.devolverReferencia());
			listaD.asignarNulo();
			duplicarLista2R(aux, listaD);
		}
	}
	
	private static <T> void duplicarLista2R(Lista<T> aux, Lista<T> listaD) {
		T elem;
		if(!aux.esNulo()) {
			elem = aux.devolverClave();
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista2R(aux, listaD);
			insertarAlPrincipio(listaD, elem);
		}
	}
	
	public static <T extends Comparable<T>> boolean buscar(Lista<T> lista, T dato) {
		if(lista != null) {
			Lista<T> aux = new TadLista<>();
			aux.asignarReferencia(lista.devolverReferencia());
			return buscarR(aux, dato);
		} else
			return false;
	}
	
	private static <T extends Comparable<T>> boolean buscarR(Lista<T> aux, T dato) {
		boolean resul = false;
		if(!aux.esNulo()) {
			if(aux.devolverClave().compareTo(dato) == 0) {
				resul = true;
			}
			else {
				aux.asignarReferencia(aux.devolverSiguiente());
				resul = buscarR(aux, dato);
			}
		}
		return resul;
	}
}