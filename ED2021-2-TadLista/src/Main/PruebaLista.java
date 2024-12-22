package Main;

import algoritmos.AlgoritmosListas;
import tadLista.Lista;
import tadLista.TadLista;

public class PruebaLista {

	public static void main(String[] args) {

		Lista<Integer> lista = new TadLista<>("Mi 1");
		Lista<Integer> aux = new TadLista<>("Mi 2");
		AlgoritmosListas.insertarAlPrincipio(lista, 5);
		AlgoritmosListas.insertarAlPrincipio(lista, 3);
		AlgoritmosListas.insertarAlPrincipio(lista, 8);

		lista.imprimirLista();
		
		lista.asignarReferencia(lista.devolverSiguiente());
		
		
		lista.imprimirLista();

		aux.asignarReferencia(lista.devolverReferencia());
		
		
		lista.imprimirLista();
		aux.imprimirLista();
		
		System.err.println("");
		AlgoritmosListas.insertarAlPrincipio(lista, 1);
		lista.imprimirLista();
		lista.asignarReferenciaSiguiente(aux.devolverSiguiente());
		lista.imprimirLista();

		aux.asignarReferenciaSiguiente(lista.devolverReferencia());
		lista.imprimirLista();

		lista.asignarReferencia(aux.devolverReferencia());
		lista.imprimirLista();


		lista.imprimirLista();
		aux.imprimirLista();
		/**NodoLista.agregarEnMedio(lista, 3, 1);
		lista.imprimirLista();
		// crear nodo para agrega el uno entre el 3 5**/

	}
}