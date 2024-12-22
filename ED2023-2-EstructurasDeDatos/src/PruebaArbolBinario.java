import algoritmos.AlgoritmosArbolesB;
import arbolBinario.Arbol;

public class PruebaArbolBinario {

	public static void main(String[] args) {
		Arbol<Integer> a4 = new Arbol<>(4);
		Arbol<Integer> a9 = new Arbol<>(9);
		Arbol<Integer> a7 = new Arbol<>();
		Arbol<Integer> a17 = new Arbol<>(17);
		Arbol<Integer> a3 = new Arbol<>();
		Arbol<Integer> a1 = new Arbol<>();
		
		Arbol.juntar(a7, 7, a4, a9);
		Arbol.juntar(a3, 3, a17, null);
		Arbol.juntar(a1, 1, a7, a3);
		a1.setNombre("Mi árbol binario");
		a1.info();
		
		System.out.println("Se muestra el árbol ordenado");
		AlgoritmosArbolesB.mostrarDatosEnOrden(a1);
		
		System.out.println("Buscar el 3: " + (a1.buscar(3)?"ENCONTRADO":"NO ENCONTRADO"));
		System.out.println("Eliminar la raíz");
		a1.eliminar(a1.getRaiz().getClave());
		a1.info();
		System.out.println("\nAltura del subárbol derecho: " + a1.altura(a1.getRaiz().getDe()));
		a3.info();
	}

}
