import algoritmos.Algoritmos;
import algoritmos.Busqueda;
import algoritmos.Ordenacion;

public class PruebaVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo v1 = new Vehiculo(Algoritmos.generarPlacaAleatoria());
		Vehiculo v2 = new Vehiculo(Algoritmos.generarPlacaAleatoria());
		Vehiculo v3 = new Vehiculo(Algoritmos.generarPlacaAleatoria());

		Vehiculo[] vector2 = new Vehiculo[4];
		int pos;

		System.out.println("Vehiculos generados");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);

		vector2[0] = v1;
		vector2[1] = v2;
		vector2[2] = v3;
		vector2[3]= new Vehiculo(Algoritmos.generarPlacaAleatoria());

		System.out.println("Vector vehiculos sin ordenar");
		for (Vehiculo ve : vector2)
			System.out.println(ve);

		System.out.println("Busqueda de dato" + v3);
		pos = Busqueda.busquedaSecuencialR(v3, vector2);
		System.out.println((pos == -1 ? "NO ENCONTRADO " : "ENCONTRADO EN:" + pos));

		Ordenacion.bubbleSort(vector2);
		for (Vehiculo ve : vector2)
			System.out.println(ve);

		System.out.println("Busqueda de dato" + v3);
		pos = Busqueda.busquedaBinariaR(v3, vector2);
		System.out.println((pos == -1 ? "NO ENCONTRADO" : "ENCONTRADO EN:" + pos));
	}

}
