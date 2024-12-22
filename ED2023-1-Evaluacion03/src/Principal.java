import algoritmos.Algoritmos;
import listaCalificadaOrdenada.Lista;
/**
 * 
 * @author Dalton
 */

public class Principal {

	public static void main(String[] args) {
		Lista<Integer> lista = new Lista<>("Calificada Ordenada");
		Integer dato;
		int pos;
			
		for(int i=1; i<=10; ++i) { //la lista tendrá exactamente 10 datos
			dato = Algoritmos.aleatorio(11, 50);
			if(!lista.busqueda(dato))
				lista.insertar(dato);
			else
				--i;			
		}		
		System.out.println("Lista Calificada Ordenada");
		System.out.println(lista);
		dato = 30;
		pos = busquedaBinaria(lista, dato);
		System.out.println("Se busca el "+ dato +" en la lista: " + (pos != -1?"ENCONTRADO en pos=" + pos:"NO ENCONTRADO"));			
	}
	
	public static <T extends Comparable<T>> int busquedaBinaria(Lista<T> lista, T dato) {

		return busquedaBinariaR(lista, dato, 0, 9);

	}

	private static <T extends Comparable<T>> int busquedaBinariaR(Lista<T> lista, T dato, int inf, int sup) {
		int centro;

		if (inf <= sup) {
			centro = (inf + sup) / 2;
			if (lista.leer(centro).compareTo(dato) == 0) {
				return centro;
			} else if (lista.leer(centro).compareTo(dato) > 0) {
				sup = centro - 1;
				centro = busquedaBinariaR(lista, dato, inf, sup);
			} else {
				inf = centro + 1;
				centro = busquedaBinariaR(lista, dato, inf, sup);
			}
		} else {
			return -1;
		}

		return centro;
	}
	
}
