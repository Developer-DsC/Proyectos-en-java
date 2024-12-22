package tad;

import java.util.Arrays;

/**
 * Clase parametrizada para realizar operaciones básicas en un arrego unidimensional
 * @author Estructuras de Datos - UTMACH
 *
 * @param <T> Tipo de dato genérico
 */
public class TADVector<T> {
	private T[] vector;
	private int longitud;
	private String nombre;
	
	/**
	 * Constructor de la clase para instaciar la estructura del vector con una
	 * longitud y un nombre
	 * @param nombre Nombre del vector
	 * @param longitud Tamaño del vector
	 */
	@SuppressWarnings("unchecked")
	public TADVector(String nombre, int longitud) {
		super();
		vector = (T[]) new Object[longitud];
		this.longitud = longitud;
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLongitud() {
		return longitud;
	}

	@Override
	public String toString() {
		return "TADVector [vector=" + Arrays.toString(vector) + ", longitud=" + longitud + ", nombre=" + nombre + "]";
	}
	
	/**
	 * Método para ingresar un elemento al vector en una posición dada
	 * @param pos Posición donde se desea ingresar el elemento
	 * @param dato Elemento que se quiere ingresar
	 * @return true si el ingreso fue exitoso, o false si no se pudo ingresar el elemento
	 */
	public boolean ingresarElemento(int pos, T dato) {
		boolean resul = false;
		
		while(pos>=0 && pos<=vector.length-1 && !resul) {
			if(leerElemento(pos) == null) {
				vector[pos] = dato;
				resul = true;
			}
			else
				pos++;
		}		
		return resul;
	}
	
	public boolean ingresarElemento(T dato) {
		return ingresarElemento(0, dato);
	}
	
	public T leerElemento(int pos) {
		if(pos>=0 && pos<=vector.length-1)
			return vector[pos];
		else
			return null;
	}
	
	public boolean modificarElemento(T dato, int pos) {
		boolean resul = false;
		
		if(pos>=0 && pos<=vector.length-1 && vector[pos]!=null) {
			vector[pos] = dato;
			resul = true;
		}		
		return resul;
	}
	
	public boolean eliminarElemento(int pos) {
		return modificarElemento(null, pos);
	}
	
	public void imprimirVector() {
		for(T elem : vector)
			if(elem != null)
				System.out.println(elem);
	}
	
	public void imprimirVectorCompleto() {
		for(int pos=0; pos<vector.length; ++pos)
			System.out.println(pos + ": " + leerElemento(pos));
	}
	
	public int buscarElemento(T dato) {
		int resul = -1;
		for(int pos=0; pos<vector.length; ++pos) {
			if(dato.equals(vector[pos])) {
				resul = pos;
				pos = vector.length;
			}
		}
		return resul;
	}
	
	public boolean modificarElementoPorBusqueda(T dato, T datoNuevo) {
		
		return false;
	}
	
	public boolean eliminarElementoPorBusqueda(T dato) {
		
		return false;
	}
}
