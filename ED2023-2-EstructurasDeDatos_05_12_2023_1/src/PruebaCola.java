import algoritmos.Algoritmos;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class PruebaCola {
	public static void main(String[] args) {
		Cola<Vehiculo> cola = new TadCola<>("Vehiculos");
		Vehiculo vehiculo;
		System.out.println("Cola " + cola.getNombre());
		for(int i = 1; i<=4; ++i) {
			cola.encolar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		}
		cola.imprimirCola();
		try {
			vehiculo = cola.desencolar();
			System.out.println("Se ha desencolado " + vehiculo);
			cola.imprimirCola();
		} catch (ColaVacia e) {
			System.out.println(e.getMessage());
		}
	}
}
