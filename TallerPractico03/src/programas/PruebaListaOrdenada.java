package programas;
/**
 * @autor Dalton
 */
import listaCalificadaOrdenada.Lista;
import algoritmos.Algoritmos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PruebaListaOrdenada {

	public static void main(String[] args) {
		Lista<Integer> lista = new Lista<Integer>("Mi Lista Ordenada");

		for (int i = 0; i < 10; i++) {
			lista.insertar(Algoritmos.aleatorio(100, 999));
		}
		lista.imprimirLista();

		System.out.println("\nNúmero de elementos en la lista: " + contar(lista));

		System.out.println("Búsqueda del 50: " + (lista.busqueda(50) ? "Encontrado\n" : "No Encontrado\n"));

		lista.eliminar(lista.leer(4));
		lista.imprimirLista();

		guardarListaEnArchivo(lista, "archivoLista.txt");
		lista = new Lista<>("Mi Lista Ordenada");
		System.out.println("\nLista borrada del archivo:");
		lista.imprimirLista();

		lista = recuperarListaDeArchivo("archivoLista.txt");
		if (lista != null) {
			System.out.println("\nLista recuperada del archivo:");
			lista.imprimirLista();
		}
	}

	private static <T extends Comparable<T>> int contar(Lista<T> lista) {
		if (lista.getInicio() != null)
			return contar(lista, 0);
		else
			return 0;
	}

	private static <T extends Comparable<T>> int contar(Lista<T> lista, int cont) {
		if (lista.leer(cont) != null)
			cont = contar(lista, cont + 1);
		return cont;
	}

	private static <T extends Comparable<T>> void guardarListaEnArchivo(Lista<T> lista, String nombreArchivo) {
		try (ObjectOutputStream guadarLista = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
			guadarLista.writeObject(lista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> Lista<T> recuperarListaDeArchivo(String nombreArchivo) {
		try (ObjectInputStream recuperarLista = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
			return (Lista<T>) recuperarLista.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
