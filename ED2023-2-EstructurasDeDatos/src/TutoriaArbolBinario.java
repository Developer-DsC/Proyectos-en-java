
import algoritmos.AlgoritmosArbol;
import tadarbolbinario.Arbol;

public class TutoriaArbolBinario {

	public static void main(String[] args) {
		Arbol<Integer> a40 = new Arbol<>(40);
		Arbol<Integer> a88 = new Arbol<>(88);
		Arbol<Integer> a72 = new Arbol<>(72);
		Arbol<Integer> a44 = new Arbol<>(44);
		Arbol<Integer> a65 = new Arbol<>();
		Arbol<Integer> a91 = new Arbol<>();
		Arbol<Integer> a20 = new Arbol<>();
		Arbol<Integer> a15 = new Arbol<>();
		Arbol<Integer> a30 = new Arbol<>();
		
		Arbol.juntar(a65, 65, a88, null);
		Arbol.juntar(a91,91, null, a72);
		Arbol.juntar(a20, 20, a40, a65);
		Arbol.juntar(a15, 15, a91, a44);
		Arbol.juntar(a30, 30, a20, a15);
		a30.setNombre("Arbol tutoria");
		a30.info();
		System.out.println("Mostrar datos ordenados: ");
		AlgoritmosArbol.mostrarDatosEnOrden(a30);


	}

}
