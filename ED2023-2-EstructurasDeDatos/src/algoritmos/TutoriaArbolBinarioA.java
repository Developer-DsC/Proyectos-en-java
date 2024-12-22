package algoritmos;

import arbolBinario.Arbol;

public class TutoriaArbolBinarioA {

	public static void main(String[] args) {
		Arbol<Integer> a40 = new Arbol<Integer>(40);
		Arbol<Integer> a88 = new Arbol<Integer>(88);
		Arbol<Integer> a72 = new Arbol<Integer>(72);
		Arbol<Integer> a44 = new Arbol<Integer>(44);
		Arbol<Integer> a65 = new Arbol<Integer>();
		Arbol<Integer> a91 = new Arbol<Integer>();
		Arbol<Integer> a20 = new Arbol<Integer>();
		Arbol<Integer> a15 = new Arbol<Integer>();
		Arbol<Integer> a30 = new Arbol<Integer>();
		
		Arbol.juntar(a65, 65, a88, null);
		Arbol.juntar(a91, 91, null, a72);
		Arbol.juntar(a20, 20, a40, a65);
		Arbol.juntar(a15, 15, a91, a44);
		Arbol.juntar(a30, 30, a20, a15);
		a30.setNombre("Arbol 30");
		a30.info();
		System.out.println("Mostrar los datos en orden");
		AlgoritmosArboles.mostrarDatosEnOrden(a30);
	}

}
