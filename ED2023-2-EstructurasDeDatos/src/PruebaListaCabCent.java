import cabeceraCentinela.Lista;
import cabeceraCentinela.NodoLista;

public class PruebaListaCabCent {
		static <T extends Comparable<T>> Lista<T> copiarLista (Lista<T> origen) {
			NodoLista<T> aux;
			Lista<T> resul = new Lista<>();
			
			aux = origen.getCab().getSig();
			while (aux != origen.getCent()) {
		 	  resul.insertar(aux.getClave());
		 	  aux = aux.getSig();
			}  
			return resul;
		}
		static <T extends Comparable<T>> void escribirLista (Lista<T> lista) {
			NodoLista<T> aux;
			
			aux = lista.getCab().getSig();
			while (aux != lista.getCent()) {
					System.out.print(aux.getClave()+" ");
					aux = aux.getSig();
			}
			System.out.println ("FIN");
		}
		public static void main(String[] args) {
			Lista<Integer> lista1 = new Lista<>();
			Lista<Integer> copia;
			
			lista1.insertar(1);
			lista1.insertar(5);
			lista1.insertar(4);
			lista1.eliminar(4);
			lista1.insertar(4);
			lista1.insertar(7);
			lista1.insertar(6);
			System.out.println ("probemos el método escribirLista:");
			escribirLista(lista1);
			lista1.insertar (9);
			lista1.eliminar (7);
			System.out.println ("probemos el método copiarLista:");
			copia= copiarLista (lista1);
			copia.imprimirLista ();
			copia.insertar(7);
			lista1.imprimirLista ();
			System.out.println ("Copia de lista1 después de insertar 7: ");
			copia.imprimirLista ();
			lista1.imprimirLista();
		}
	}
