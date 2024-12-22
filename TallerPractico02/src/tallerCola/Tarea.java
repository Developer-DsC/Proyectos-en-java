package tallerCola;

import java.util.Random;

public class Tarea{
	 private  int marcaTiempo;
	 private int paginas;
	public Tarea(int tiempo) {
		this.marcaTiempo = tiempo;
		Random rand= new Random();
		this.paginas= rand.nextInt(20)+1;
	}
	 
	 public int obtenerMarca() {
		 return this.marcaTiempo;
	 }
	 
	 public int obtenerPaginas() {
		 return this.paginas;
	 }
	 
	 public int tiempoEspera(int tiempoActual) {
		 return tiempoActual-marcaTiempo;
	 }
}

