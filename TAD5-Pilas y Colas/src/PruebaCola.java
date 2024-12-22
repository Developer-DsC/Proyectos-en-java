import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class PruebaCola {

	public static void main(String[] args) {
		Cola<Integer> cola = new TadCola<Integer>();
		int dato;

		// Agregar(1)
		System.out.println("\nAgregar(1)");
		cola.encolar(1);
		cola.imprimirCola();

		// Agregar(2)
		System.out.println("\nAgregar(2)");
		cola.encolar(2);
		cola.imprimirCola();

		// Leer
		System.out.println("\nLeer");
		try {
			dato = cola.primero();
			System.out.println("Se leyó:" + dato);
		} catch (ColaVacia e) {
			e.printStackTrace();
		}
		cola.imprimirCola();

		// Remover
		System.out.println("\nRemover");
		try {
			cola.quitarPrimero();
			System.out.println("Se removió el primer elemento");
		} catch (ColaVacia e) {
			e.printStackTrace();
		}
		cola.imprimirCola();

		// Agregar(3)
		System.out.println("\nAgregar(3)");
		cola.encolar(3);
		cola.imprimirCola();

		// Agregar(4)
		System.out.println("\nAgregar(4)");
		cola.encolar(4);
		cola.imprimirCola();

		// Extraer
		System.out.println("\nExtraer");
		try {
			dato = cola.desencolar();
			System.out.println("Se extrajo:" + dato);
		} catch (ColaVacia e) {
			e.printStackTrace();
		}
		cola.imprimirCola();

		// Remover
		System.out.println("\nRemover");
		try {
			cola.quitarPrimero();
			System.out.println("Se removió el primer elemento");
		} catch (ColaVacia e) {
			e.printStackTrace();
		}
		cola.imprimirCola();

		// Agregar(5)
		System.out.println("\nAgergar(5)");
		cola.encolar(5);
		cola.imprimirCola();

		// Leer
		System.out.println("\nLeer");
		try {
			dato = cola.primero();
			System.out.println("Se leyó:" + dato);
		} catch (ColaVacia e) {
			e.printStackTrace();
		}
		cola.imprimirCola();

		// Prueba final Cola
		// Agregar(8)
		System.out.println("\nAgregar(8)");
		cola.encolar(8);
		cola.imprimirCola();
		// Ver Final de la Cola
		System.out.println("\nFinal de la Cola:");
		try {
			System.out.println("Final de la cola: " + TadCola.verFinalCola(cola));
		} catch (ColaVacia e) {
			e.printStackTrace();
		}
	}
}
