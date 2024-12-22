import algoritmos.Algoritmos;
import algoritmos.AlgoritmosColas;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class PruebaTadCola {
	public static void main(String[] args) {
		Cola<Vehiculo> cola = new TadCola<>("Vehiculos");
		Vehiculo vehiculo;
		
		System.out.println("Cola " + cola.getNombre());
		for(int i=1; i<=4; ++i) {
			cola.encolar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		}
		cola.imprimirCola();
		try {
			vehiculo = cola.desencolar();
			System.out.println("Se ha desencolado " + vehiculo);
			
		} catch (ColaVacia e) {
			System.out.println(e.getMessage());
			
		}
		System.out.println("La cola " + cola.getNombre() + " tiene ahora " +
				AlgoritmosColas.contarCola(cola) + " elementos");
		cola.imprimirCola();
		System.out.println("El útimo de la cola: " + ultimo(cola));
		cola.imprimirCola();
	}
	
	public static <T> T ultimo(Cola<T> cola) {
		T resul;
		try {
			resul = ultimoR(cola);
			cola.invertirCola();
		} catch (ColaVacia e) {
			resul = null;
		}
		return resul;
	}
	
	private static <T> T ultimoR(Cola<T> cola) throws ColaVacia {
		T resul = null;
		T elem;

		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			if(cola.colaVacia())
				resul =  elem;
			else
				resul = ultimoR(cola);
			cola.encolar(elem);
		}

		return resul;
	}
}
