import algoritmos.Algoritmos;

public class PruebaAlgoritmos {

	public static void main(String[] args) {
		int n = 10;
		long fibo;
		long tiempo;
		
		tiempo = System.nanoTime();
		fibo = Algoritmos.fibonacci(n);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Término "+n+" de la serie de Fibonacci: " + fibo + " en "+tiempo+"ns");
		
		tiempo = System.nanoTime();
		fibo = Algoritmos.fibonacci(n);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Término "+n+" de la serie de Fibonacci: " + fibo + " en "+tiempo+"ns");
		
		tiempo = System.nanoTime();
		fibo = Algoritmos.fibonacciOptimo(n);
		tiempo = System.nanoTime() - tiempo;
		System.out.println("Término "+n+" de la serie de Fibonacci: " + fibo + " en "+tiempo+"ns");
	
		Algoritmos.serieFibonacci(n);
	}

}
