import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class PruebaPila {

	public static void main(String[] args) {
		Pila<Integer> pila = new TadPila<Integer>();
		int dato;

		// Agregar(1)
		System.out.println("\nAgregar(1)");
		pila.apilar(1);
		pila.imprimirPila();

		// Agregar(2)
		System.out.println("\nAgregar(2)");
		pila.apilar(2);
		pila.imprimirPila();

		// Leer
		System.out.println("\nLeer");
		try {
			dato = pila.cima();
			System.out.println("Se leyó:" + dato);
		} catch (PilaVacia e) {
			e.printStackTrace();
		}
		pila.imprimirPila();

		// Remover
		System.out.println("\nRemover");
		try {
			pila.decapitar();
			System.out.println("Se decapitó la pila");
		} catch (PilaVacia e) {
			e.printStackTrace();
		}
		pila.imprimirPila();

		// Agregar(3)
		System.out.println("\nAgregar(3)");
		pila.apilar(3);
		pila.imprimirPila();

		// Agregar(4)
		System.out.println("\nAgregar(4)");
		pila.apilar(4);
		pila.imprimirPila();

		// Extraer
		System.out.println("\nExtraer");
		try {
			dato = pila.desapilar();
			System.out.println("Se desapiló:" + dato);
		} catch (PilaVacia e) {
			e.printStackTrace();
		}
		pila.imprimirPila();

		// Remover
		System.out.println("\nRemover");
		try {
			pila.decapitar();
			System.out.println("Se decapitó la pila");
		} catch (PilaVacia e) {
			e.printStackTrace();
		}
		pila.imprimirPila();

		// Agregar(5)
		System.out.println("\nAgergar(5)");
		pila.apilar(5);
		pila.imprimirPila();

		// Leer
		System.out.println("\nLeer");
		try {
			dato = pila.cima();
			System.out.println("Se leyó:" + dato);
		} catch (PilaVacia e) {
			e.printStackTrace();
		}
		pila.imprimirPila();

		// Prueba ver fondo de pila
		// Agregar(6)
		System.out.println("\nAgregar(6)");
		pila.apilar(6);
		pila.imprimirPila();

		// Ver Fondo de la Pila
		System.out.println("\nVer Fondo de la Pila:");
		try {
			System.out.println("Fondo de la pila: " + TadPila.verFondoPila(pila));
		} catch (PilaVacia e) {
			e.printStackTrace();
		}
	}
}
