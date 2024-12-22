import algoritmos.Algoritmos;
import listaCalificadaOrdenada.Lista;


public class PruebaOtrasListas {

	public static void main(String[] args) {
		Lista<Integer> lista1 = new Lista<>("Lista1 CO");
		cabeceraCentinela.Lista<Integer> lista2 = new cabeceraCentinela.Lista<>("Lista 2 CC");
		circularesOrdenadas.Lista<Integer> lista3 = new circularesOrdenadas.Lista<>("Lista 3 CiO");
		doblementeEnlazadasOrdenadas.Lista<Integer> lista4 = new doblementeEnlazadasOrdenadas.Lista<>("Lista 4 DE");
		
		for(int i=1; i<=10; ++i)
			lista1.insertar(Algoritmos.aleatorio(11, 50));
		System.out.println(lista1);
		lista1.imprimirLista();
		
		for(int i=1; i<=10; ++i)
			lista2.insertar(Algoritmos.aleatorio(11, 50));
		System.out.println(lista2);
		lista2.imprimirLista();
		
		for(int i=1; i<=10; ++i)
			lista3.insertar(Algoritmos.aleatorio(11, 50));
		System.out.println(lista3);
		lista3.imprimirLista();

		for(int i=1; i<=10; ++i)
			lista4.insertar(Algoritmos.aleatorio(11, 50));
		System.out.println(lista4);
		lista4.imprimirLista();
	}

}
