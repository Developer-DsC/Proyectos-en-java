package principal;

import algoritmos.Algoritmos;
import grafos.Grafo;
import grafos.GrafoLA;
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
		// Adyacentes de entrada
		verticeD = Algoritmos.aleatorio(0, numV - 1);
		verticesIn(grafo, verticeD);
	}

	public static void verticesIn(Grafo grafo, int verticeO) {
		System.out.print("Vértices adyacentes que llegan a " + verticeO + ": ");
		if (grafo.gradoOut(verticeO) == 0) {
			System.out.println("El vertice no tiene vertices adyacentes");
		} else {
			TadCola<Integer> adyacentes = new TadCola<Integer>();
			int verticeAnalizado = 0;
			verticesInR(grafo, verticeO, adyacentes, verticeAnalizado);
			System.out.println();
			adyacentes.imprimirCola();
		}
	}

	private static void verticesInR(Grafo grafo, int verticeO, TadCola<Integer> adyacentes, int verticeAnalizado) {
		if (verticeAnalizado < grafo.obtenerNumVertices()) {
			if (((grafo.existeArista(verticeAnalizado, verticeO)))) {
				adyacentes.encolar(verticeAnalizado);
				verticesInR(grafo, verticeO, adyacentes, verticeAnalizado + 1);
			} else {
				verticesInR(grafo, verticeO, adyacentes, verticeAnalizado + 1);
			}
		}
	}
}
