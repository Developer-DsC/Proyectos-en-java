package tadPila;

public class TadPila<T> implements Pila<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodoPila<T> pila;
	private String nombre;
	
	
	public TadPila () {
		this(null, "");
	}
	
    public TadPila(NodoPila<T> pila, String nombre) {
		super();
		this.pila = pila;
		this.nombre = nombre;
	}
    
	public TadPila(NodoPila<T> pila) {
		this(pila, "");
	}

	public TadPila(String nombre) {
		this(null, nombre);
		
	}

	public String getNombre() {
		return nombre;
	}
    

	public boolean pilaVacia () {
      	return pila == null;
    }
        
    public void eliminarPila () {
      	pila = null;
    }

    public T cima () throws PilaVacia {
    	if (pilaVacia ())
       		throw new PilaVacia ("La pila esta vacia");
       	return pila.dato;
    }
        
    public void apilar (T dato) {
        NodoPila<T> aux;
        aux = new NodoPila<> (dato, pila);
        pila = aux;
    }

    public T desapilar () throws PilaVacia {
        T resultado;
        if (pilaVacia ()) {  
             throw new PilaVacia ("Desapilar: La pila esta vacia");
        }
        resultado = pila.dato;
        pila = pila.siguiente;
        return resultado;
    }

    public void decapitar () throws PilaVacia {
        if (pilaVacia ()) {  
             throw new PilaVacia ("Decapitar: La pila esta vacia");
        }
        pila = pila.siguiente;
    }

    public void imprimirPila () {
        NodoPila<T> aux;
        System.out.println ("Estado de la pila: " + this.nombre + ": ");
        aux = pila;
        while (aux != null) {
            System.out.println (aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println ();
    }
        
    public int numElemPila () {
        NodoPila<T> aux;	
        int resul;
        aux = pila;
        resul = 0;
        while (aux != null) {
         	++resul;
        	aux = aux.siguiente;
        }
        return resul;
    }
}