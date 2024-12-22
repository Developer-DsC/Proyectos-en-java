import algoritmos.Algoritmos;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;
import tadPila.Pila;
import tadPila.TadPila;

public class Principal {
/**
 * @author Dalton
 * @date 20/12/2023
 * @param args
 * @throws ColaVacia
 */
	public static void main(String[] args) throws ColaVacia {
		Pila<Persona> pilaAtendidos = new TadPila<>("Antendidos");
		Cola<Persona> colaNormal = new TadCola<>("Normal");
		Cola<Persona> colaTerceraEdad = new TadCola<>("Tercera edad");
		Persona persona;
		int i, numCola;
		int numTercera = 0;
		int numNormal = 0;
		int colaVaciaTercera = 0;
		// Hay 100 personas esperando - se separan entre mayores de edad y normales
		for (i = 1; i <= 100; i++) {
			persona = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 90));

			// if que controla si una persona es tercera edad o normal
			if (persona.getEdad() > 65) {
				// if que controla cuantas veces se uso la cola de tercera edad cuando quedo
				// vacia.
				if (colaTerceraEdad.colaVacia()) {
					colaVaciaTercera++;
				}
				colaTerceraEdad.encolar(persona);
			} else {
				colaNormal.encolar(persona);
			}

			// Atención a personas - Entra 10 personas que estaban esperando
			if (i >= 10 && i % 2 == 0) {
				if (!colaTerceraEdad.colaVacia()) {
					persona = colaTerceraEdad.desencolar();
					numTercera++;
				} else {
					persona = colaNormal.desencolar();
					numNormal++;
				}
				pilaAtendidos.apilar(persona);
			}
		} // fin for

		System.out.println("\nIngresaron " + (i - 1) + " personas");

		// Numero de atendedos numPila
		System.out.println("\nSe atendieron a " + pilaAtendidos.numElemPila() + " personas: ");

		// contadores de tercera edad y normal en las personas atendidas
		System.out.println(numTercera + " personas de la tercera edad y " + numNormal + " personas más");

		System.out.println("\nLa cola de la tercera edad se utilizó: " + colaVaciaTercera);
		System.out.println("");
		pilaAtendidos.imprimirPila();

		numCola = colaTerceraEdad.numElemCola();
		System.out.println(numCola == 0 ? "\nNo quedan personas de la tercera edad por atender :)"
				: "\nQuedan por atender a " + numCola + " personas de la tercera edad\n");
		
		if (numCola > 0) {
			colaTerceraEdad.imprimirCola();
		}
		
		numCola = colaNormal.numElemCola();
		System.out.println(numCola == 0 ? "\nNo quedan personas por atender :)"
				: "\nQuedan por atender a " + numCola + " personas por atender\n");
		
		if (numCola > 0) {
			colaNormal.imprimirCola();
		}
	}
}