package principal;

import algoritmos.Algoritmos;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;
import tadPila.Pila;
import tadPila.TadPila;
/**
 * 
 * @author Dalton
 *
 */

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pila<Persona> pilatendidos = new TadPila<>("atendidos");
		Cola<Persona> colaNormal = new TadCola<>("normal");
		Cola<Persona> colaTercera = new TadCola<>("tercera edad");
		Persona persona;
		int i, numcola;
		int cont3edad = 0, contuso3edad = 0;
		for (i = 1; i <= 100; ++i) {
			persona = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 90));

			if (persona.getEdad() > 65) {
				if (colaTercera.colaVacia()) {
					++contuso3edad;
				}
				colaTercera.encolar(persona);
			} else {
				colaNormal.encolar(persona);
			}
			if (i >= 10 && i % 2 == 0) {
				// atencion
				try {
					if (!colaTercera.colaVacia()) {
						persona = colaTercera.desencolar();
						++cont3edad;
					} else {
						persona = colaNormal.desencolar();
					}
					pilatendidos.apilar(persona);
				} catch (ColaVacia e) {
					System.out.println(e.getMessage());
				}

			}
		} // fin for
		System.out.println("Se ingresaron " + (i - 1) + " personas");
		System.out.println("Se atendieron a " + pilatendidos.numElemPila() + " personas");
		System.out.println(cont3edad + " personas de la tercera edad y " + (pilatendidos.numElemPila() - cont3edad)
				+ " personas mas");
		System.out.println("La cola de la tercera edad se uso " + contuso3edad + " veces");
		pilatendidos.imprimirPila();
		numcola = colaTercera.numElemCola();
		System.out.println(
				(numcola > 0) ? "Quedan por atender a " + numcola + "personas de tercera edad" : "no quedan personas");
		if (numcola > 0) {
			System.out.println();
			colaTercera.imprimirCola();
		}
		numcola = colaNormal.numElemCola();
		System.out.println((numcola > 0) ? "Quedan por atender a " + numcola + "personas" : "no quedan personas por atender de la tercera edad");
		if (numcola > 0) {
			System.out.println();
			colaNormal.imprimirCola();
		}

	}

}
