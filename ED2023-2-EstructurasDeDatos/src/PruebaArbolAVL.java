import arbolBinario.Arbol;
import arbolBinario.ArbolAVL;
import arbolBinario.NodoArbol;
import tadCola.Cola;
import tadCola.TadCola;

public class PruebaArbolAVL {

	public static void main(String[] args) {
		ArbolAVL<Integer> avl1 = new ArbolAVL<>("AVL1");
		ArbolAVL<String> avl2 = new ArbolAVL<>("AVL2");
		ArbolAVL<Libro> avl3 = new ArbolAVL<>("AVL3");
		
		//AVL1
		avl1.insertar(65);
		avl1.insertar(50);
		avl1.insertar(23);
		avl1.insertar(70);
		avl1.insertar(82);
		avl1.insertar(68);
		avl1.insertar(39);
		avl1.insertar(10);
		avl1.insertar(43);
		avl1.insertar(59);
		avl1.insertar(66);
		avl1.info();
		System.out.println("Se elimina el 82");
		avl1.eliminar(82);
		System.out.println("Se elimina el 82");
		avl1.eliminar(10);
		System.out.println("Se elimina el 82");
		avl1.eliminar(39);
		System.out.println("Se elimina la raíz");
		avl1.eliminar(avl1.getRaiz().getClave());
		avl1.info();
		AVLaColaInOrder(avl1).imprimirCola();
		
		//AVL2
		System.out.println();
		avl2.insertar("carrera");
		avl2.insertar("de");
		avl2.insertar("Ingeniería");
		avl2.insertar("en");
		avl2.insertar("Tecnologías");
		avl2.insertar("de");
		avl2.insertar("la");
		avl2.insertar("Información");
		avl2.info();

		//AVL3
		System.out.println();
		avl3.insertar(new Libro("Biblia", 1455));
		avl3.insertar(new Libro("Viaje al centro de la Tierra", 1864));
		avl3.insertar(new Libro("Estructuras de Datos", 2022));
		avl3.insertar(new Libro("Don Quijote de la Mancha", 1605));
		avl3.insertar(new Libro("Metamorfosis", 1915));
		avl3.insertar(new Libro("Mobi Dick", 1851));
		avl3.info();
	}
	
	public static <T extends Comparable<T>> Cola<T> AVLaColaInOrder(Arbol<T> arbol){
		Cola<T> cola = new TadCola<>();
		inOrder(arbol.getRaiz(), cola);
		return cola;
	}
	
	private static <T extends Comparable<T>> void inOrder(NodoArbol<T> arbol, Cola<T> cola) {
		if(arbol!=null) {			
			inOrder(arbol.getIz(), cola);
			cola.encolar(arbol.getClave());
			inOrder(arbol.getDe(), cola);
		}
	}
}






