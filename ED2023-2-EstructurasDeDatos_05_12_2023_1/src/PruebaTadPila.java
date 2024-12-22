import algoritmos.AlgoritmosPilas;
import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class PruebaTadPila {
/**
 * @author Dalton
 */
	public static void main(String[] args) { 
		// Nunca poner throws en el main porque el programa se cae
		
		Pila<Integer> pila1 = new TadPila<>("Mi pilita");
		Pila<Libro> pila2 = new TadPila<>("Mis Libritos");

		Integer dato;
		Libro libro;

		pila1.apilar(5);
		pila1.apilar(8);
		pila1.apilar(9);

		pila1.imprimirPila();

		System.out.println("Informacion de la pila: " + pila1.getNombre());

		try {

			System.out.println("Cima de la pila: " + pila1.cima());

			System.out.println("Tiene " + pila1.numElemPila() + " elementos");

			dato = pila1.desapilar();
			System.out.println("Dato desapilado: " + dato);

			pila1.imprimirPila();

			pila1.decapitar();
			System.out.println("Se ha elimnado la cima");

			pila1.imprimirPila();

			pila1.eliminarPila();
			System.out.println("Se ha borrado la pila");

			pila1.imprimirPila();

		} catch (PilaVacia e) {

			System.out.println(e.getMessage());

		}
		
		// Pila de Libros
		pila2.apilar(new Libro("Estricturas de Datos", 2021));
		pila2.apilar(new Libro("50 Sobras de Grey", 2011));
		pila2.apilar(new Libro("El método", 2015));

		pila2.imprimirPila();

		try {

			System.out.println(
					"La pila " + pila2.getNombre() + " tiene " + AlgoritmosPilas.contarPila(pila2) + " elementos");

		} catch (PilaVacia e) {

			System.out.println(e.getMessage());

		}

		libro = new Libro("Revista playboy", 1997);
		System.out.println("Sumergir el libro" + libro);

		try {

			AlgoritmosPilas.sumergir(pila2, libro);

		} catch (PilaVacia e) {

			System.out.println(e.getMessage());

		}
		pila2.imprimirPila();
	}
}