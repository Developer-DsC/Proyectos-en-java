import grafos.GrafoMA;
import algoritmos.AlgoritmosGrafos;

public class PruebaGrafoMA {

	public static void main(String[] args) {
		GrafoMA grafo1 = new GrafoMA (10,true);
		GrafoMA grafo2 = new GrafoMA (5,false);
		int [][] MC;
		
		//grafo dirigido
		grafo1.setNombre("Mi Grafo-Dirigido");
		grafo1.insertaVertice(4);
		grafo1.insertaArista(0, 1);
		grafo1.insertaArista(0, 2);
		grafo1.insertaArista(1, 0);
		grafo1.insertaArista(1, 3);
		AlgoritmosGrafos.estadoGrafo(grafo1);
		
		System.out.println("Matriz de camino");
		MC = AlgoritmosGrafos.matrizCaminos(grafo1);
		AlgoritmosGrafos.imprimirMatriz(MC);
		
		//grafo no dirigido
		grafo2.setNombre("Mi Grafo-No Dirigido");
		grafo2.insertaVertice(5);
		grafo2.insertaArista(0, 2);
		grafo2.insertaArista(0, 3);
		grafo2.insertaArista(1, 2);
		grafo2.insertaArista(1, 3);
		grafo2.insertaArista(2, 2);
		grafo2.insertaArista(1, 4);
		grafo2.insertaArista(2, 3);
		AlgoritmosGrafos.estadoGrafo(grafo2);
		
		
		
		
		
	}

}
