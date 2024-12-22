
/**
 * @author Dalton Cornejo
 * @date 29/02/2024
 * @version 1.2
 */
import java.util.Random;
import algoritmos.Algoritmos;
import arbolBinario.Arbol;
import arbolBinario.ArbolAVL;
import arbolBinario.ArbolBB;
import arbolBinario.NodoArbol;
import tadCola.Cola;
import tadCola.TadCola;

public class Principal {

	public static void main(String[] args) {
		Character letra = 83;
		ArbolAVL<Character> avl = new ArbolAVL<Character>("Mi AVL", letra);
		int n = 9;

		for (int i = 2; i <= n; ++i) {
			letra = Algoritmos.letraMayAleatoria();
			if (!avl.buscar(letra))
				avl.insertar(letra);
			else
				--i;
		}
		avl.listarAmplitudNiveles();
		letra = aleatorio(avl);
		System.out.println("Se obtiene un dato aleatorio del árbol: " + letra);
		System.out.println("El dato " + letra + " está en el nivel " + (letra != null ? avl.nivel(letra) : ""));
		System.out.println("Cola con los datos ordenados");
		ABBToCola(avl).imprimirCola();
	}

	//Metodos recursivos requeridos
	public static <T extends Comparable<T>> T aleatorio(Arbol<T> arbol) {
		Random random = new Random();
		if (arbol.getRaiz() != null) {
			return aleatorioRecursivo(arbol.getRaiz(),random);
		}
		return null;
	}

	private static <T extends Comparable<T>> T aleatorioRecursivo(NodoArbol<T> arbol,Random random) {
		int nodoIzquierdo = tamañoArbol(arbol.getIz());
		int nodoDerecho = tamañoArbol(arbol.getDe());
		int nodosDelArbol = nodoIzquierdo + nodoDerecho + 1;
		int randomIndex = random.nextInt(nodosDelArbol);

		if (randomIndex < nodoIzquierdo) {
			return aleatorioRecursivo(arbol.getIz(),random);
		} else if (randomIndex == nodoIzquierdo) {
			return arbol.getClave();
		} else {
			return aleatorioRecursivo(arbol.getDe(),random);
		}
	}

	private static <T extends Comparable<T>> Cola<T> ABBToColaRecursivo(NodoArbol<T> arbol, Cola<T> cola) {
		if (arbol != null) {
			ABBToColaRecursivo(arbol.getIz(), cola);
			cola.encolar(arbol.getClave());
			ABBToColaRecursivo(arbol.getDe(), cola);
		}
		return cola;
	}

	private static <T extends Comparable<T>> int tamañoArbol(NodoArbol<T> arbol) {
		if (arbol == null) {
			return 0;
		}
		return 1 + tamañoArbol(arbol.getIz()) + tamañoArbol(arbol.getDe());
	}

	public static <T extends Comparable<T>> Cola<T> ABBToCola(ArbolBB<T> arbol) {
		if (arbol == null) {
			return null;
		}
		Cola<T> cola = new TadCola<>();
		return ABBToColaRecursivo(arbol.getRaiz(), cola);
	}
}