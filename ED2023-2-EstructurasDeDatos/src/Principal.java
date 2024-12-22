import algoritmos.Algoritmos;
import listaCalificadaOrdenada.Lista;
import listaCalificadaOrdenada.NodoLista;


public class Principal {

	public static void main(String[] args) {
		Lista<Integer> lista = new Lista<>("Calificada Ordenada");
			
		for(int i=1; i<=10; ++i)
			lista.insertar(Algoritmos.aleatorio(11, 50));
		System.out.println("Lista Calificada Ordenada");
		System.out.println(lista);
		System.out.println("Se imprime invertida");
		imprimirInvertida(lista);
		
		
	}
	
	public static <T extends Comparable<T>> void imprimirInvertida(Lista<T> lista) {
		imprimirInvertidaAux(lista.getInicio());

	}
	
	private static <T extends Comparable<T>> void imprimirInvertidaAux(NodoLista<T> nodo) {
		if(nodo !=null) {
			imprimirInvertidaAux(nodo.getSig());
			System.out.println(nodo.getClave());
		}
	}
	
}
