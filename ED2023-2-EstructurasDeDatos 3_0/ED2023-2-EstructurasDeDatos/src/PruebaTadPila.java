import algoritmos.AlgoritmosPilas;
import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class PruebaTadPila {

	public static void main(String[] args) {
		Pila<Integer> pila1 = new TadPila<>("Pila 1");
		Pila<Libro> pila2 = new TadPila<>("Libros");
		Integer dato;
		Libro libro;
		
		pila1.apilar(2);
		pila1.apilar(5);
		pila1.apilar(3);
		pila1.imprimirPila();
		
		System.out.println("Información de la pila " + pila1.getNombre());
		try {
			System.out.println("Cima de la pila: " + pila1.cima());
			System.out.println("Tiene "+ pila1.numElemPila() +" elementos");
			dato = pila1.desapilar();
			System.out.println("Dato desapilado: " + dato);
			pila1.imprimirPila();
			pila1.decapitar();
			System.out.println("Se ha eliminado la cima");
			pila1.imprimirPila();
			pila1.eliminarPila();
			System.out.println("Se ha borrado la pila");
			pila1.imprimirPila();
		} catch (PilaVacia e) {
			System.out.println(e.getMessage());
		}
		
		//pila de libros
		pila2.apilar(new Libro("Estructuras de Datos", 2021));
		pila2.apilar(new Libro("Huasipungo", 1934));
		pila2.apilar(new Libro("Estructuras de Datos para Dummies", 2020));
		pila2.imprimirPila();
		try {
			System.out.println("La pila " + pila2.getNombre() + " tiene " + 
						AlgoritmosPilas.contarPila(pila2) + " elementos");
		} catch (PilaVacia e) {
			System.out.println(e.getMessage());
		}
		libro = new Libro("Cien años de Soledad", 1967);
		System.out.println("Sumergir el libro " + libro);
		try {
			AlgoritmosPilas.sumergir(pila2, libro);
		} catch (PilaVacia e) {
			System.out.println(e.getMessage());
		}
		pila2.imprimirPila();
		System.out.println("Elemento del fondo: " + fondo(pila2));
		pila2.imprimirPila();
	}

	
	public static <T> T fondo(Pila<T> pila) {
		T resul = null;
		T elem;
		try {
			if(!pila.pilaVacia()) {
				elem = pila.desapilar();
				if(pila.pilaVacia())
					resul =  elem;
				else
					resul = fondo(pila);
				pila.apilar(elem);
			}
		}catch(PilaVacia e) {
			
		}
		return resul;
	}
}
