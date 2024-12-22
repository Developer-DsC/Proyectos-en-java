package algoritmos;
import tadLista.Lista;
import tadLista.TadLista;

public class AlgoritmosListas {
	
	public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {
		lista.crearNodo();
		lista.asignarClave(dato);
	}
	public static <T> int contar(Lista<T> Lista) {
		Lista<T> aux =new TadLista<T>();
		aux.asignarReferencia(Lista.devolverReferencia());
		return contarR(aux);
	}
	
	private static <T> int contarR(Lista<T>aux) {
		if(!aux.esNulo()) {
			aux.asignarReferencia(aux.devolverSiguiente());
			return 1+contarR(aux);
		}
		else
			return 0;
	}
}
