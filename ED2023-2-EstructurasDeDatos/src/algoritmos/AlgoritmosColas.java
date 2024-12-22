package algoritmos;

import tadCola.Cola;
import tadCola.ColaVacia;

public class AlgoritmosColas {
	
	public static <T> int contarCola(Cola<T> cola) {
		int resul = 0;
		try {
			resul = contarColaR(cola);
			cola.invertirCola();
		} catch (ColaVacia e) {
			
		}
		
		return resul;
	}
	
	private static <T> int contarColaR(Cola<T> cola) throws ColaVacia {
		int resul;
		T elem;

		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			resul = 1 + contarColaR(cola);
			cola.encolar(elem);
		}
		else
			resul = 0;		
		return resul;
	}
	
	public static <T> T ultimo(Cola<T> cola) {
		T resul;
		
		try {
			resul = ultimoR(cola);
			cola.invertirCola();
		}
		catch(ColaVacia e) {
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
				resul = elem;
			else
				resul = ultimoR(cola);
			cola.encolar(elem);
		}
		return resul;
	}
}
