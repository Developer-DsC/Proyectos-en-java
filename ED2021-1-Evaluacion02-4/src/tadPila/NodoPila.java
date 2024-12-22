package tadPila;
//Revisado 01/07/2021

public class NodoPila<T> {
	// Atributos accesibles desde otras rutinas del paquete
	T dato;
	NodoPila<T> siguiente;

	// Constructores
	NodoPila (T elemento, NodoPila<T> n) { 
		dato = elemento; 
		siguiente = n; 
	}
}
