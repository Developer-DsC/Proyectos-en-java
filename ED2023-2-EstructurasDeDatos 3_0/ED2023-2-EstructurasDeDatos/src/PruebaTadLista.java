import algoritmos.AlgoritmosListas;
import tadLista.Lista;
import tadLista.TadLista;

public class PruebaTadLista {

	public static void main(String[] args) {
		Lista<Integer> lista = new TadLista<>("MiLista");
		Lista<Integer> aux = new TadLista<>();
		int pos=4, cont=0;
		
		AlgoritmosListas.insertarAlPrincipio(lista, 8);
		AlgoritmosListas.insertarAlPrincipio(lista, 5);
		
		
		AlgoritmosListas.insertarAlPrincipio(aux, 1);
		aux.asignarReferenciaSiguiente(lista.devolverSiguiente());
		lista.asignarReferenciaSiguiente(aux.devolverReferencia());
		
		aux.asignarNulo();
		lista.imprimirLista();
		aux.imprimirLista();
		
		aux.asignarReferencia(lista.devolverReferencia());
		while(cont<pos && !lista.esNulo() && pos>=1 && pos<=AlgoritmosListas.contar(lista)) {
			
			++cont;
			if(cont == pos)
				System.out.println("Elemento en posición "+pos+" es " + aux.devolverClave());
			aux.asignarReferencia(aux.devolverSiguiente());
		}
		
	}

}
