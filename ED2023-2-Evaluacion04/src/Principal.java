import algoritmos.Algoritmos;
import arbolBinario.ArbolAVL;

public class Principal {
	public static void main(String[] args) {		
		Character letra=83;
		ArbolAVL<Character> avl = new ArbolAVL<Character>("Mi AVL", letra);
		int n=9;

		System.out.println("Ingreso 1: " + letra);
		for(int i=2; i<=n; ++i) {			
			letra = Algoritmos.letraMayAleatoria();
			if(!avl.buscar(letra)) {
				avl.insertar(letra);
				System.out.println("Ingreso " + i + ": " + letra);
			} else
				--i;		
		}
		avl.listarAmplitudNiveles();
		
		/*OPCIONAL + 2/10 puntos
		Escriba AQUÍ código para eliminar la raíz del árbol resultante (0.5)
		Presente el diagrama del árbol AVL luego de la eliminación de la raíz (1.5)
		Recuerde identificar tipo de rotación si lo hay y aplicarlo
		Recuerde que si es doble, requiere diagrama intermedio*/
		
		avl.eliminar(avl.getRaiz().getClave());
	}
}
