import algoritmos.Algoritmos;

public class PruebaRecursividad {

	public static void main(String[] args) {
		int n=45;
		
		System.out.println("La suma desde 1 hasta " + n + " es: " + Algoritmos.suma(n));
		System.out.println("El MCD entre 96 y 128 es: " + Algoritmos.mcd(96, 128));
		System.out.println("Término "+n+" de la serie de Fibonacci: " + Algoritmos.fibonacci(n));
		System.out.println("Serie de Fibonacci hasta el término " + n);
		Algoritmos.serieFibonacci(n);
		System.out.println("\nAlgoritmo optimizado para el n-simo término de Fibonacci");
		System.out.println("Término "+n+" de la serie de Fibonacci: " + Algoritmos.fibonacciOptimo(n));
		System.out.println("Serie de Fibonacci hasta el término " + n);
		Algoritmos.serieFibonacciOptimo(n);
	}
}
