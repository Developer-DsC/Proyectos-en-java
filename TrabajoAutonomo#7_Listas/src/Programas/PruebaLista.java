package Programas;
/**
 * @author Dalton
 */
import algoritmos.AlgoritmosListas;
import tadLista.Lista;
import tadLista.TadLista;

public class PruebaLista {

    public static void main(String[] args) {
    	Lista<Integer> lista = new TadLista<>("Mi Lista");
    	 
    	AlgoritmosListas.insertarAlPrincipio(lista, 20);
    	AlgoritmosListas.insertarAlPrincipio(lista, 40);
    	AlgoritmosListas.insertarAlPrincipio(lista, 60);
    	AlgoritmosListas.insertarAlPrincipio(lista, 50);
    	AlgoritmosListas.insertarAlPrincipio(lista, 10);
    	
    	lista.imprimirLista();     
    	Integer mayor = AlgoritmosListas.encontrarMayor(lista);
    	Integer menor = AlgoritmosListas.encontrarMenor(lista);
    	
    	System.out.println("El menor elemento es: " + menor);
        System.out.println("El mayor elemento es: " + mayor);
        
        System.out.println("Ingreso exitoso: "+AlgoritmosListas.insertarEnPosicion(lista, 7, 6));
        lista.imprimirLista();
    }
    
    
}
