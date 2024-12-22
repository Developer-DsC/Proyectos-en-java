package programas;
/**
 * @autor Dalton
 */
import circularesOrdenadas.Lista;
import circularesOrdenadas.NodoLista;
import java.util.Scanner;
import algoritmos.Algoritmos;
import java.io.*;

public class PruebaListaCircular {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Lista<Integer> lista = new Lista<Integer>("Lista Circular");

		for (int i = 0; i < 10; i++) {
			lista.insertar(Algoritmos.aleatorio(100, 999));
		}
		
		lista.imprimirLista();
		Scanner scanner = new Scanner(System.in);
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

		System.out.println("Número de elementos en la lista: " + contar(lista));

		guardarListaEnArchivo(lista, "archivoListaCircular.txt");
		lista = new Lista<>("Lista Circular");
		System.out.println("\nLista borrada del archivo:");
		lista.imprimirLista();

		lista = recuperarListaDeArchivo("archivoListaCircular.txt");
		if (lista != null) {
			System.out.println("\nLista recuperada del archivo:");
			lista.imprimirLista();
		}
	}

	private static <T extends Comparable<T>> boolean buscarEnLista(Lista<T> lista, T clave) {
		if (lista.ultimo != null)
			return buscarEnLista(lista, lista.ultimo.sig, clave);
		else
			return false;
	}

	private static <T extends Comparable<T>> boolean buscarEnLista(Lista<T> lista, NodoLista<T> nodo, T clave) {
		if (!nodo.equals(lista.ultimo)) {
			if (nodo.clave.equals(clave)) {
				return true;
			}
			nodo = nodo.sig;
			return buscarEnLista(lista, nodo, clave);
		} else {
			return nodo.clave.equals(clave);
		}
	}

	private static <T extends Comparable<T>> boolean eliminarDeLista(Lista<T> lista, T clave) {
		if (lista.ultimo != null)
			return eliminarDeLista(lista, lista.ultimo.sig, clave);
		else
			return false;
	}

	private static <T extends Comparable<T>> boolean eliminarDeLista(Lista<T> lista, NodoLista<T> nodo, T clave) {
		if (!nodo.equals(lista.ultimo)) {
			if (nodo.clave.equals(clave)) {
				lista.eliminar(nodo.clave);
				return true;
			}
			nodo = nodo.sig;
			return eliminarDeLista(lista, nodo, clave);
		} else {
			if (nodo.clave.equals(clave)) {
				lista.eliminar(nodo.clave);
				return true;
			}
			return false;
		}
	}

	private static <T extends Comparable<T>> int contar(Lista<T> lista) {
		Lista<T> aux = new Lista<T>("aux");
		if (lista.ultimo == null)
			return 0;
		else {
			aux.ultimo = lista.ultimo.sig;
			return contar(aux, lista.ultimo, 0);
		}

	}

	private static <T extends Comparable<T>> int contar(Lista<T> aux, NodoLista<T> ultimo, int cont) {
		if (!aux.ultimo.equals(ultimo)) {
			aux.ultimo = aux.ultimo.sig;
			cont = 1 + contar(aux, ultimo, cont);
		} else
			cont = cont + 1; // para contar el último
		return cont;

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
