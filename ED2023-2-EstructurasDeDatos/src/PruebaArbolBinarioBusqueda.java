import algoritmos.Algoritmos;
import arbolBinario.ArbolBB;

public class PruebaArbolBinarioBusqueda {

	public static void main(String[] args) {
		ArbolBB<Integer> abb1 = new ArbolBB<>("Mi ABB #1");
		ArbolBB<Persona> abb2 = new ArbolBB<>("Mi ABB #2");
		
		abb1.insertar(50);
		abb1.insertar(80);
		abb1.insertar(20);
		abb1.insertar(10);
		abb1.insertar(60);
		abb1.insertar(40);
		abb1.insertar(30);
		abb1.insertar(15);
		abb1.insertar(90);
		abb1.insertar(75);
		abb1.info();
		System.out.println("Eliminar la raíz");
		abb1.eliminar(abb1.getRaiz().getClave());
		abb1.info();
		//Árbol de personas
		abb2.insertar(new Persona("Goku", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.insertar(new Persona("Vegeta", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.insertar(new Persona("Gohan", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.insertar(new Persona("Trunks", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.insertar(new Persona("N17", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.insertar(new Persona("Krilin", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.insertar(new Persona("Piccolo", Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 65)));
		abb2.info();
		
	}

}
