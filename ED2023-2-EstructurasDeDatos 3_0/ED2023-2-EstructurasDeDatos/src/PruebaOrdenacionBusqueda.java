import algoritmos.Algoritmos;
import algoritmos.Busqueda;
import algoritmos.Ordenacion;

public class PruebaOrdenacionBusqueda {

	public static void main(String[] args) {
		Persona p1 = new Persona("Fausto", Algoritmos.cedulaAleatorio("07"), 51);
		Persona p2 = new Persona("Fabián", Algoritmos.cedulaAleatorio("07"), 51);
		Persona p3 = new Persona("Rosita", Algoritmos.cedulaAleatorio("07"), Algoritmos.aleatorio(30, 70));
		Persona[] vector1 = new Persona[4];
		int pos;
		long tiempo;
		
		System.out.println("Personas generadas");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		vector1[0] = p1;
		vector1[1] = p2;
		vector1[2] = p3;
		vector1[3] = new Persona("Mateo", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(1, 18));
		
		System.out.println("Vector de Personas sin ordenar");
		for(Persona elem : vector1)
			System.out.println(elem);
		
		System.out.println("Búsqueda secuencial de dato " + p3);
		tiempo = System.nanoTime();
		pos = Busqueda.busquedaSecuencial(p3, vector1);
		tiempo = System.nanoTime() - tiempo;
		System.out.println((pos==-1?"NO ENCONTRADO":"ENCONTRADO EN pos=" + pos) + " en " + tiempo + "ns");
		
		
		System.out.println("Búsqueda de dato " + p3);
		tiempo = System.nanoTime();
		pos = Busqueda.busquedaSecuencial(p3, vector1);
		tiempo = System.nanoTime() - tiempo;
		System.out.println((pos==-1?"NO ENCONTRADO":"ENCONTRADO EN pos=" + pos) + " en " + tiempo + "ns");
		
		
		
		tiempo = System.nanoTime();
		Ordenacion.insercionR(vector1);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Vector de Personas ordenado en " + tiempo + "ns");
		for(Persona elem : vector1)
			System.out.println(elem);
		
		System.out.println("Búsqueda de dato " + p3);
		tiempo = System.nanoTime();
		pos = Busqueda.busquedaBinaria(p3, vector1);
		tiempo = System.nanoTime() - tiempo;
		System.out.println((pos==-1?"NO ENCONTRADO":"ENCONTRADO EN pos=" + pos) + " en " + tiempo + "ns");
		
		System.out.println("Búsqueda de dato " + p3);
		tiempo = System.nanoTime();
		pos = Busqueda.busquedaSecuencial(p3, vector1);
		tiempo = System.nanoTime() - tiempo;
		System.out.println((pos==-1?"NO ENCONTRADO":"ENCONTRADO EN pos=" + pos) + " en " + tiempo + "ns");
		
	}

}
