import Algoritmos.AlgoritmosArbol;
import tadarbolbinario.Arbol;

public class PruebaArbolBinario {
	public static void main (String []args) {
		Arbol<Integer> a4 = new Arbol<>(4);
		Arbol<Integer> a9 = new Arbol<>(9);
		Arbol<Integer> a7 = new Arbol<>();
		Arbol<Integer> a17 = new Arbol<>(17);
		Arbol<Integer> a3 = new Arbol<>();
		Arbol<Integer> a1 = new Arbol<>();
		
		Arbol.juntar(a7, 7, a4, a9);
		Arbol.juntar(a3, 3, a17, null);
		Arbol.juntar(a1, 1, a7, a3);
		a1.setNombre("Mi arbol binario");
		
		System.out.println("\nSe muestran los datos del arbol ordenados: ");
		AlgoritmosArbol.mostrarDatosEnOrden(a1);
		
		a1.info();
		
		System.out.println("\nBuscar el 3:" + (a1.buscar(3)?"Encontrado":"No encontrado"));
		
		System.out.println("\nEliminar la raiz");
		a1.eliminar(a1.getRaiz().getClave());
		
		a1.info();
		
		System.out.println("\nAltura del subarbol derecho: " + a1.altura(a1.getRaiz().getDe()));
		
	}
}
