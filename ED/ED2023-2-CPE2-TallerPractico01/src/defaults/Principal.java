package defaults;

//6.4.6.1
import Algoritmos.Algoritmos;
import Algoritmos.Ordenacion;
import Algoritmos.Busqueda;

public class Principal {
	static long time;

	public static void main(String[] args) {
		Persona[] vectorPersonas = Algoritmos.generarPersonas(100);
		Persona copiaVector0[] = Algoritmos.copiar(vectorPersonas);
		Persona copiaVector1[] = Algoritmos.copiar(vectorPersonas);
		Persona copiaVector2[] = Algoritmos.copiar(vectorPersonas);
		Persona copiaVector3[] = Algoritmos.copiar(vectorPersonas);
		Persona personaAleatoria = new Persona(Algoritmos.cedulaAleatorio("07"), Algoritmos.aleatorio(60, 110));

		Algoritmos.imprimirVector(vectorPersonas);

		time = System.nanoTime();
		Ordenacion.ordBurbuja(copiaVector0);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para ordenar vector por bubbleSort = " + time);
		System.out.println("Vector ordenado por bubbleSort: \n");
		Algoritmos.imprimirVector(copiaVector0);

		time = System.nanoTime();
		Ordenacion.ordBurbuja(copiaVector1);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para ordenar vector por bubbleSort = " + time);
		System.out.println("Vector ordenado por bubbleSort: \n");
		Algoritmos.imprimirVector(copiaVector1);

		time = System.nanoTime();
		Ordenacion.ordSeleccion(copiaVector2);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para ordenar vector por seleccion = " + time);
		System.out.println("Vector ordenado por bubbleSort: \n");
		Algoritmos.imprimirVector(copiaVector2);

		time = System.nanoTime();
		Ordenacion.ordInsercion(copiaVector3);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para ordenar vector por insercion = " + time);
		System.out.println("Vector ordenado por bubbleSort: \n");
		Algoritmos.imprimirVector(copiaVector3);

		System.out.println(personaAleatoria);

		time = System.nanoTime();
		int pos = Busqueda.busquedaSec(vectorPersonas, personaAleatoria);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para buscar en el vector sin ordenar de manera Secuencual = " + time);
		System.out.println((pos == -1 ? "No encontrado" : "encontrado en posicion= " + pos));

		time = System.nanoTime();
		int pos1 = Busqueda.busquedaSec(copiaVector1, personaAleatoria);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para buscar en el vector ordenado de manera Secuencual = " + time);
		System.out.println((pos == -1 ? "No encontrado" : "encontrado en posicion= " + pos1));

		time = System.nanoTime();
		int pos2 = Busqueda.busquedaBin(copiaVector1, personaAleatoria);
		time = System.nanoTime() - time;
		System.out.println("\nTiempo para buscar en el vector ordenado de manera Binaria = " + time);
		System.out.println((pos == -1 ? "No encontrado" : "encontrado en posicion= " + pos2));
	}
}