package Algoritmos;

import Algoritmos.Algoritmos;
import defaults.Persona;

public class Algoritmos {

	/**
	 * Metodo para generar objetos tipo persona aleatorios y los agrega al vector
	 * @param <T>    Clase gen�rica que indica el tipo de objeto del vector
	 * @param vector Vector cuyos elementos se desean generar de manera aleatoria y
	 *               almacenar en un vector
	 */
	
	public static <T> Persona[] generarPersonas(int n) {
		Persona[] vectorpersonas = new Persona[n];
		
		for (int i = 0; i < n; i++) {
			Persona p = new Persona(Algoritmos.cedulaAleatorio("07"), Algoritmos.aleatorio(60, 110));
			vectorpersonas[i] = p;
		}
		return vectorpersonas;
	}

	/**
	 * Método que reciba un arreglo unidimensional cualquiera y devuelva una copia
	 * de dicho arreglo
	 * 
	 * @param <T> Clase gen�rica que indica el tipo de objeto del vector
	 */
	public static <T> T[] copiar(T[] a) {
		return a.clone();
	}

	/**
	 * Método que reciba un arreglo unidimensional cualquiera y lo muestre por
	 * pantalla
	 * 
	 * @param <T>    Clase gen�rica que indica el tipo de objeto del vector
	 * @param vector Vector cuyos elementos se desean imprimir en pantalla
	 */
	public static <T> void imprimir(T[] a) {
		for (T elem : a)
			System.out.println(elem.toString());
	}

	/**
	 * Inicializa el m�todo recursivo que imprime en pantalla el contenido de un
	 * arreglo unidimensional
	 * 
	 * @param <T>    Clase gen�rica que indica el tipo de objeto del vector
	 * @param vector Vector cuyos elementos se desean imprimir en pantalla
	 */
	public static <T> void imprimirVector(T[] vector) {
		imprimirVector(vector, 0);
	}

	/**
	 * M�todo recursivo para imprimir en pantalla el contenido de un arreglo
	 * unidimensional
	 * 
	 * @param <T>    Clase gen�rica que indica el tipo de objeto del vector
	 * @param vector Vector cuyos elementos se desean imprimir en pantalla
	 * @param pos    Posici�n inicial
	 */
	private static <T> void imprimirVector(T[] vector, int pos) {
		if (pos >= 0 && pos < vector.length) {
			System.out.println(" "+ vector[pos]);
			imprimirVector(vector, pos + 1);
		}
	}

	/**
	 * Genera un n�mero entero aleatorio en un rango, entre <em>m</em> y <em>n</em>
	 * (<em>m</em> &lt; <em>n</em>).
	 * 
	 * @param m Valor inicial del rango
	 * @param n Valor final del rango
	 * @return N�mero entero aleatorio en el rango dado
	 */
	public static int aleatorio(int m, int n) {
		return (int) redondearDecimales(Math.random() * (n - m) + m, 0);
	}

	/**
	 * Genera un n�mero real aleatorio en un rango, entre <em>m</em> y <em>n</em>
	 * (<em>m</em> &lt; <em>n</em>) con un n�mero de decimales dado.
	 * 
	 * @param m               Valor inicial del rango
	 * @param n               Valor final del rango
	 * @param numeroDecimales N�mero de decimales que se requieren en el n�mero
	 *                        generado
	 * @return N�mero real aleatorio en el rango y con n�mero de decimales dados
	 */
	public static double aleatorio(int m, int n, int numeroDecimales) {
		return redondearDecimales(Math.random() * (n - m) + m, numeroDecimales);
	}

	/**
	 * Redondea un n�mero real <em>valor</em> al n�mero de decimales
	 * <em>numeroDecimales</em> dado.
	 * 
	 * @param valor           N�mero real a redondear
	 * @param numeroDecimales N�mero de decimales que se requieren
	 * @return N�mero real redondeado al n�mero de decimales dado
	 */
	public static double redondearDecimales(double valor, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valor;
		parteEntera = Math.floor(resultado);
		resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return resultado;
	}

	/**
	 * Genera el d�gito verificador que valida una c�dula. Solo se requieren los
	 * primeros 9 d�gitos de la c�dula.
	 * 
	 * @param cedula9 Los primeros 9 d�gitos de una c�dula
	 * @return D�gito verificador que es el d�cimo d�gito de la c�dula
	 */
	public static int generarVerificadorDeCedula(String cedula9) {
		int verificador, tercerDigito;
		int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		int suma, digito;

		try {

			if (cedula9.length() == 9) // Solo 9 d�gitos el d�cimo es el verificador
			{
				tercerDigito = Integer.parseInt(cedula9.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validaci�n c�dula
					// El d�cimo d�gito se lo considera d�gito verificador
					suma = 0;
					digito = 0;
					for (int i = 0; i < cedula9.length(); i++) {
						digito = Integer.parseInt(cedula9.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if (suma % 10 == 0) {
						verificador = suma % 10;
					} else {
						verificador = 10 - (suma % 10);
					}
				} else {
					verificador = -1;
				}
			} else {
				verificador = -1;
			}
		} catch (NumberFormatException nfe) {
			verificador = -1;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de generacion");
			verificador = -1;
		}
		return verificador;
	}

	/**
	 * Genera un n�mero de c�dula por provincia (c�digo de 2 caracteres)
	 * @param provincia C�digo de provincia. Para El Oro es 07
	 * @return Un n�mero de c�dula aleatorio de la provincia
	 */
	public static String cedulaAleatorio(String provincia) {
		StringBuffer cedula9 = new StringBuffer();
		int decimoDigito;

		do {
			cedula9.delete(0, cedula9.length()); // vac�a el StringBuffer
			for (int i = 3; i <= 9; ++i) { // genera 9 d�gitos
				cedula9.append((int) aleatorio(0, 9, 0)); // del 0 al 9
			}
			cedula9.insert(0, provincia);
			decimoDigito = generarVerificadorDeCedula(cedula9.toString());
		} while (decimoDigito < 0);
		return cedula9.toString() + decimoDigito;
	}

	/**
	 * Genera un n�mero de c�dula aleatorio de acuerdo a las 24 provincias. Utiliza
	 * una clase Enum Provincia con el c�digo de cada una.
	 * 
	 * @return Un n�mero de c�dula aleatorio de una de las 24 provincias
	 */
	public static String cedulaAleatorio() {
		int provincia;

		provincia = aleatorio(1, Provincia.values().length);
		if (provincia < 10)
			return cedulaAleatorio("0" + String.valueOf(provincia));
		else
			return cedulaAleatorio(String.valueOf(provincia));
	}

	/**
	 * M�todo para verificar si una c�dula es v�lida.
	 * 
	 * @param cedula C�dula a verificar su validez.
	 * @return true si la c�dula es v�lida y false si la c�dula no es v�lida.
	 */
	public static boolean verificaCedula(String cedula) {
		int digitoVerificador = generarVerificadorDeCedula(cedula.substring(0, cedula.length() - 1));
		int decimoDigito = Character.getNumericValue(cedula.charAt(9));
		return digitoVerificador == decimoDigito;
	}
}