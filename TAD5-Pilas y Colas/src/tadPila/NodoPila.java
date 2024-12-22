package tadPila;
//Revisado 29/09/2010
import java.io.Serializable;

public class NodoPila<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	// Atributos accesibles desde otras rutinas del paquete
	T dato;
	NodoPila<T>siguiente;

	// Constructores
	NodoPila (T elemento, NodoPila<T>n) { 
		dato = elemento; 
		siguiente = n; 
	}
}
