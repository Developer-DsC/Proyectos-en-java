package principal;

import algoritmos.Algoritmos;
import algoritmos.AlgoritmosGrafos;
import grafos.Grafo;
import grafos.GrafoLA;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Principal {

	public static void main(String[] args) {
		GrafoLA grafo = new GrafoLA(5, true);
		int numV = 5, numA = 8, verticeO, verticeD;

		grafo.insertaVertice(numV);
		for (int i = 1; i <= numA; ++i) {
			verticeO = Algoritmos.aleatorio(0, numV - 1);
			verticeD = Algoritmos.aleatorio(0, numV - 1);
			if (!grafo.existeArista(verticeO, verticeD))
				grafo.insertaArista(verticeO, verticeD);
			else
				--i;
		}
		grafo.imprimirGrafo();

		// Adyacentes de salida
		verticeO = Algoritmos.aleatorio(0, numV - 1);
		verticesOut(grafo, verticeO);
		// Demuestra si el grafo es Dirigido o No Dirigido
		System.out.println("\nGrafo 2: es dirigido? " + (!grafo.esNoDirigido() ? "Si" : "No"));
	}
	public static void verticesOut(Grafo grafo, int verticeO) {
	    System.out.print("Vértices adyacentes desde " + verticeO + ": ");
	    if (grafo.gradoOut(verticeO) == 0) {
	        System.out.println("El vertice no tiene vertices adyacentes");
	    } else {
	        TadCola<Integer> cola = new TadCola<>();
	        boolean[] visitados = new boolean[grafo.obtenerNumVertices()];
	        boolean[] enCola = new boolean[grafo.obtenerNumVertices()];

	        cola.encolar(verticeO);
	        visitados[verticeO] = true;
	        enCola[verticeO] = true;

	        while (!cola.colaVacia()) {
	            try {
	                int v = cola.desencolar();
	                enCola[v] = false;

	                // Iterate through all vertices to check adjacency
	                for (int i = 0; i < grafo.obtenerNumVertices(); i++) {
	                    if (grafo.existeArista(v, i)) {
	                        if (!visitados[i]) {
	                            cola.encolar(i);
	                            visitados[i] = true;
	                            enCola[i] = true;
	                        } else if (enCola[i]) {
	                            // Hay un ciclo, imprime el vértice analizado
	                            System.out.print(i + " ");
	                        }
	                    }
	                }
	            } catch (ColaVacia e) {
	                System.err.println("Error en la cola: " + e.getMessage());
	            }
	        }
	        System.out.println();
	    }
	}









	
}