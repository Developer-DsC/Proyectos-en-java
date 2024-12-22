package programas;
/**
 * @autor Dalton
 */
import doblementeEnlazadasOrdenadas.Lista;
import doblementeEnlazadasOrdenadas.NodoLista;
import java.util.Scanner;
import algoritmos.Algoritmos;
import java.io.*;

public class PruebaListaDoubleEO {

	public static void main(String[] args) {
		Lista<Integer> lista = new Lista<Integer>("Lista DEO");

		for (int i = 0; i < 10; i++) {
			lista.insertar(Algoritmos.aleatorio(100, 999));
		}

		lista.imprimirLista();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Ingrese el número a buscar en la lista: ");
			int numeroBuscado = scanner.nextInt();
			boolean encontrado = buscarEnLista(lista, numeroBuscado);

			if (encontrado) {
				System.out.println("El número " + numeroBuscado + " está en la lista.\n");
			} else {
				System.out.println("El número " + numeroBuscado + " no está en la lista.\n");
			}

			System.out.print("Ingrese el número a eliminar de la lista: ");
			int numeroEliminar = scanner.nextInt();
			boolean eliminado = eliminarDeLista(lista, numeroEliminar);

			if (eliminado) {
				System.out.println("El número " + numeroEliminar + " fue eliminado de la lista.\n");
			} else {
				System.out.println("El número " + numeroEliminar + " no estaba en la lista.\n");
			}
		}

		System.out.println("Número de elementos en la lista: " + contar(lista));

		System.out.println("Número de números primos en la lista: " + contarPrimos(lista));

		guardarListaEnArchivo(lista, "archivoListaDoubleEO.txt");
		lista = new Lista<>("Lista DEO");
		System.out.println("\nLista borrada del archivo:");
		lista.imprimirLista();

		lista = recuperarListaDeArchivo("archivoListaDoubleEO.txt");
		if (lista != null) {
			System.out.println("\nLista recuperada del archivo:");
			lista.imprimirLista();
		}
	}

	private static <T extends Comparable<T>> boolean buscarEnLista(Lista<T> lista, T clave) {
		if (lista.inicio != null)
			return buscarEnLista(lista, lista.inicio, clave);
		else
			return false;
	}

	private static <T extends Comparable<T>> boolean buscarEnLista(Lista<T> lista, NodoLista<T> nodo, T clave) {
		if (nodo != null) {
			if (nodo.clave.equals(clave)) {
				return true;
			}
			nodo = nodo.sig;
			return buscarEnLista(lista, nodo, clave);
		} else {
			return false;
		}
	}

	private static <T extends Comparable<T>> boolean eliminarDeLista(Lista<T> lista, T clave) {
		if (lista.inicio != null)
			return eliminarDeLista(lista, lista.inicio, clave);
		else
			return false;
	}

	private static <T extends Comparable<T>> boolean eliminarDeLista(Lista<T> lista, NodoLista<T> nodo, T clave) {
		if (nodo != null) {
			if (nodo.clave.equals(clave)) {
				lista.eliminar(nodo.clave);
				return true;
			}
			nodo = nodo.sig;
			return eliminarDeLista(lista, nodo, clave);
		} else {
			return false;
		}
	}

	private static <T extends Comparable<T>> int contar(Lista<T> lista) {
		//Lista<T> aux = new Lista<T>("aux");
		if (lista.inicio != null) {
			//aux.inicio = lista.inicio;
			return contar(lista, lista.inicio, 0);
		} else
			return 0;
	}

	private static <T extends Comparable<T>> int contar(Lista<T> lista, NodoLista<T> nodo, int cont) {
		if (nodo != null) {
			nodo = nodo.sig;
			cont = 1 + contar(lista, nodo, cont);
		}
		return cont;
	}

	private static <T extends Comparable<T>> int contarPrimos(Lista<T> lista) {
	    if (lista.inicio != null)
	        return contarPrimos(lista, lista.inicio, 0);
	    else
	        return 0;
	}

	private static <T extends Comparable<T>> int contarPrimos(Lista<T> lista, NodoLista<T> nodo, int cont) {
	    if (nodo != null) {
	        int clave = (int) nodo.clave;
	        if (esPrimo(clave)) {
	            cont++;
	        }
	        nodo = nodo.sig;
	        cont = contarPrimos(lista, nodo, cont);
	    }
	    return cont;
	}

	private static boolean esPrimo(int num) {
	    return esPrimo(num, 2);
	}

	private static boolean esPrimo(int num, int div) {
	    if (num / 2 < div)
	        return true;
	    else if (num % div == 0)
	        return false;
	    else
	        return esPrimo(num, div + 1);
	}

	private static <T extends Comparable<T>> void guardarListaEnArchivo(Lista<T> lista, String nombreArchivo) {
		try (ObjectOutputStream guadarLista = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
			guadarLista.writeObject(lista);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> Lista<T> recuperarListaDeArchivo(String nombreArchivo) {
		try (ObjectInputStream recuperarLista = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
			return (Lista<T>) recuperarLista.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
