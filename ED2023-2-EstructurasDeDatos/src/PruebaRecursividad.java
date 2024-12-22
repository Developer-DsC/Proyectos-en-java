import algoritmos.Algoritmos;

public class PruebaRecursividad {

	public static void main(String[] args) {
		int n=45;
		
		System.out.println("La suma desde 1 hasta " + n + " es: " + Algoritmos.suma(n));
		System.out.println("El MCD entre 96 y 128 es: " + Algoritmos.mcd(96, 128));
		System.out.println("T�rmino "+n+" de la serie de Fibonacci: " + Algoritmos.fibonacci(n));
		System.out.println("Serie de Fibonacci hasta el t�rmino " + n);
		Algoritmos.serieFibonacci(n);
		System.out.println("\nAlgoritmo optimizado para el n-simo t�rmino de Fibonacci");
		System.out.println("T�rmino "+n+" de la serie de Fibonacci: " + Algoritmos.fibonacciOptimo(n));
		System.out.println("Serie de Fibonacci hasta el t�rmino " + n);
		Algoritmos.serieFibonacciOptimo(n);
	}
}
