package Programas;

import tadarbolbinario.Arbol;
import tadarbolbinario.ArbolBB;
import tadarbolbinario.NodoArbol;

public class TestArbolBB {

	public static void main(String[] args) {
		ArbolBB<Persona> arbolBB = new ArbolBB<Persona>("MiArbolBB");
		Persona persona10 = new Persona("0714372661", "Alan Coronado");
		Persona personaX = new Persona("0700000000", "DeadPool");
		long time;
		boolean encontrado;

		/*
		 * 1 0721687531 John Bocca
		 * 
		 * 2 0705297810 Brian Banegas
		 * 
		 * 3 0700903750 Richard Briones
		 * 
		 * 4 0718834146 Dennis Rivera
		 * 
		 * 5 0745348854 Adi Shumi
		 * 
		 * 6 0753927813 Ada Lomas
		 * 
		 * 7 0705355188 Linus Torres
		 * 
		 * 8 0724593975 Alan Tumbaco
		 * 
		 * 9 0733723480 Bill Gallardo
		 * 
		 * 10 0714372661 Alan Coronado
		 */

		// Arbol B
		Arbol<Persona> arbolP10 = new Arbol<Persona>(persona10);
		Arbol<Persona> arbolP1 = new Arbol<Persona>(new Persona("0721687531", "John Bocca"));
		Arbol<Persona> arbolP4 = new Arbol<Persona>();
		Arbol.juntar(arbolP4, new Persona("0718834146", "Dennis Rivera"), arbolP10, arbolP1);

		Arbol<Persona> arbolP9 = new Arbol<Persona>(new Persona("0733723480", "Bill Gallardo"));
		Arbol<Persona> arbolP6 = new Arbol<Persona>(new Persona("0753927813", "Ada Lomas"));
		Arbol<Persona> arbolP5 = new Arbol<Persona>();
		Arbol.juntar(arbolP5, new Persona("0745348854", "Adi Shumi"), arbolP9, arbolP6);

		Arbol<Persona> arbolP8 = new Arbol<Persona>();
		Arbol.juntar(arbolP8, new Persona("0724593975", "Alan Tumbaco"), arbolP4, arbolP5);

		Arbol<Persona> arbolP2 = new Arbol<Persona>(new Persona("0705297810", "Brian Banegas"));
		Arbol<Persona> arbolP3 = new Arbol<Persona>();
		Arbol.juntar(arbolP3, new Persona("0700903750", "Richard Briones"), null, arbolP2);

		Arbol<Persona> arbolB = new Arbol<Persona>();
		Arbol.juntar(arbolB, new Persona("0705355188", "Linus Torres"), arbolP3, arbolP8);
		arbolB.info();

		System.out.println("\nBusqueda de la persona " + persona10 + " como objeto");
		time = System.nanoTime();
		encontrado = arbolB.buscar(persona10);
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + persona10 + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");

		System.out.println("\nBusqueda de la persona " + personaX + " como objeto");
		time = System.nanoTime();
		encontrado = arbolB.buscar(personaX);
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + personaX + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");

		System.out.println("\nBusqueda de la persona " + persona10 + " por cedula");
		time = System.nanoTime();
		encontrado = buscarB(arbolB.getRaiz(), persona10.getCedula());
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + persona10 + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");
		System.out.println();

		System.out.println("\nBusqueda de la persona " + personaX + " por cedula");
		time = System.nanoTime();
		encontrado = buscarB(arbolB.getRaiz(), persona10.getCedula());
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + personaX + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");

		System.out.println("\nNumero de nodos del Arbol Binario de Busqueda: " + arbolB.numeroDeNodos());
		System.out.println("Altura de Arbol Binario de Busqueda: " + arbolB.altura());
		System.out.println("Altura del subArbol Izquierdo: " + alturaSubArbol(arbolB.getRaiz().getIz()));
		System.out.println("Altura del subArbol Derecho: " + alturaSubArbol(arbolB.getRaiz().getDe()));
		System.out.println("El mayor dato del Arbol Binario de Busqueda es: " + arbolB.mayor());
		System.out.println("El menor dato del Arbol Binario de Busqueda es: " + arbolB.menor());

		arbolB.eliminar(arbolB.getRaiz().getClave());
		arbolB.listarAmplitudNiveles();

		// Arbol BB

		arbolBB.insertar(new Persona("0721687531", "John Bocca"));
		arbolBB.insertar(new Persona("0705297810", "Brian Banegas"));
		arbolBB.insertar(new Persona("0700903750", "Richard Briones"));
		arbolBB.insertar(new Persona("0718834146", "Dennis Rivera"));
		arbolBB.insertar(new Persona("0745348854", "Adi Shumi"));
		arbolBB.insertar(new Persona("0753927813", "Ada Lomas"));
		arbolBB.insertar(new Persona("0705355188", "Linus Torres"));
		arbolBB.insertar(new Persona("0724593975", "Alan Tumbaco"));
		arbolBB.insertar(new Persona("0733723480", "Bill Gallardo"));
		arbolBB.insertar(persona10);
		arbolBB.info();

		System.out.println("\nBusqueda de la persona " + persona10+ " como objeto");
		time = System.nanoTime();
		encontrado = arbolBB.buscar(persona10);
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + persona10 + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");

		System.out.println("\nBusqueda de la persona " + personaX + " como objeto");
		time = System.nanoTime();
		encontrado = arbolBB.buscar(personaX);
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + personaX + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");
		
		System.out.println("\nBusqueda de la persona " + persona10 + " por cedula");
		time = System.nanoTime();
		encontrado = buscarBB(arbolB.getRaiz(), persona10.getCedula());
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + persona10 + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");
		System.out.println();

		System.out.println("\nBusqueda de la persona " + personaX + " por cedula");
		time = System.nanoTime();
		encontrado = buscarBB(arbolB.getRaiz(), persona10.getCedula());
		time = System.nanoTime() - time;
		System.out.println("Tiempo de busqueda de la persona: " + personaX + " en " + time + " nanosegundos");
		System.out.println(((encontrado) ? "Encontrado" : "No encontrado") + " en " + time + " nanosegundos ");

		System.out.println("\nNumero de nodos del arbol binario: " + arbolBB.numeroDeNodos());
		System.out.println("Altura de arbol binario: " + arbolBB.altura());
		System.out.println("Altura del subArbol Izquierdo: " + alturaSubArbol(arbolBB.getRaiz().getIz()));
		System.out.println("Altura del subArbol Derecho: " + alturaSubArbol(arbolBB.getRaiz().getDe()));
		System.out.println("El mayor dato del Arbol binario es: " + arbolBB.mayor());
		System.out.println("El menor dato del Arbol binario es: " + arbolBB.menor());

		arbolBB.eliminar(arbolBB.getRaiz().getClave());
		arbolBB.listarAmplitudNiveles();

	}

	static boolean buscarB(NodoArbol<Persona> arbol, String cedula) {
		boolean resul = false;
		if (arbol != null)
			if (arbol.getClave().getCedula().compareTo(cedula) == 0)
				resul = true;
			else {
				resul = buscarB(arbol.getIz(), cedula);
				if (!resul)
					resul = buscarB(arbol.getDe(), cedula);
			}
		return resul;
	}

	static boolean buscarBB(NodoArbol<Persona> arbol, String cedula) {
		boolean resul = false;
		if (arbol != null)
			if (arbol.getClave().getCedula().compareTo(cedula) == 0)
				resul = true;
			else {
				if (arbol.getClave().getCedula().compareTo(cedula)

						> 0) {
					resul = buscarBB(arbol.getIz(), cedula);
				} else {
					resul = buscarBB(arbol.getDe(), cedula);
				}
			}
		return resul;
	}

	static <T extends Comparable<T>> int alturaSubArbol(NodoArbol<T> arbol) {
		Arbol<T> aux = new Arbol<>();
		aux.setRaiz(arbol);
		return aux.altura();
	}
}