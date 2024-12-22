package tadPila;
//Revisado 01/07/2021

public interface Pila<T> {
	boolean pilaVacia ();
	void eliminarPila ();
	T cima () throws PilaVacia;
	void apilar (T x);
	T desapilar () throws PilaVacia;
	void decapitar () throws PilaVacia;
	void imprimirPila ();
	int numElemPila ();
}

