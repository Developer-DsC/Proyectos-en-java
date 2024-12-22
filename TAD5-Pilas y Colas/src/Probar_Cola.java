import Algoritmos.Persona;
import tad.TADTeclado;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;
import java.io.IOException;

public class Probar_Cola {
	public static void main(String[] args) {

		Cola<Persona> colaPersonas = new TadCola<Persona>("Personas");
		TADTeclado teclado = new TADTeclado();
		Persona persona;
		String nombre = "", cedula = "";
		int edad = 0;
		double peso = 0.0;
		int opcion = 0;

		colaPersonas.encolar(new Persona("0705", "Joselyn", 21, 135.5));
		colaPersonas.encolar(new Persona("0702", "Dylan", 19, 120.8));
		colaPersonas.encolar(new Persona("0706", "Darwin", 22, 110.7));
		colaPersonas.encolar(new Persona("0708", "Josue", 19, 115.1));
		colaPersonas.encolar(new Persona("0709", "Maria", 17, 136.4));

		do {
			mostrarMenu();
			try {
				opcion = teclado.leerInt();
			} catch (NumberFormatException | IOException e) {

			}

			switch (opcion) {

			case 1:
				System.out.println("DATOS DE LA PERSONA:");
				try {
					nombre = teclado.leerString("Escriba el nombre de la persona");
				} catch (IOException e) {
					System.out.println("ERROR! intentelo de nuevo");
				}
				try {
					cedula = teclado.leerString("Digite la c�dula de " + nombre);
				} catch (IOException e) {
					System.out.println("ERROR! intentelo de nuevo");
				}
				try {
					edad = teclado.leerInt("Digite la edad de " + nombre);
				} catch (NumberFormatException | IOException e) {
					System.out.println("ERROR! la edad es un dato entero");
				}
				try {
					peso = teclado.leerDouble("Digite el peso de " + nombre);
				} catch (NumberFormatException | IOException e) {
					System.out.println("ERROR! el peso es un dato double");
				}

				persona = new Persona(cedula, nombre, edad, peso);
				colaPersonas.encolar(persona);
				break;
			case 2:
				try {
					colaPersonas.quitarPrimero();
				} catch (ColaVacia e) {
					System.out.println("decapitar: La pila est� vac�a");
				}

				break;
			case 3:
				colaPersonas.imprimirCola();
				colaPersonas.mostrarEstadoCola();
				break;
			case 4:
				try {
					System.out.println("El dato mayor es: " + TadCola.verMayorCola(colaPersonas));
				} catch (ColaVacia e) {
					System.out.println("La cola est� vac�a");
				}

				break;
			case 5:
				try {
					System.out.println("El dato menor es: " + TadCola.verMenorCola(colaPersonas));
				} catch (ColaVacia e) {
					System.out.println("La cola est� vac�a");
				}

				break;
			case 6:
				System.out.println("DATOS DE LA PERSONA A BUSCAR:");
				try {
					nombre = teclado.leerString("Escriba el nombre de la persona");
				} catch (IOException e) {
					System.out.println("ERROR! intentelo de nuevo");
				}
				try {
					cedula = teclado.leerString("Digite la c�dula de " + nombre);
				} catch (IOException e) {
					System.out.println("ERROR! intentelo de nuevo");
				}
				try {
					edad = teclado.leerInt("Digite la edad de " + nombre);
				} catch (NumberFormatException | IOException e) {
					System.out.println("ERROR! la edad es un dato entero");
				}
				try {
					peso = teclado.leerDouble("Digite el peso en libras, de " + nombre);
				} catch (NumberFormatException | IOException e) {
					System.out.println("ERROR! el peso es un dato double");
				}

				persona = new Persona(cedula, nombre, edad, peso);

				try {
					if (TadCola.buscarDatoCola(colaPersonas, persona))
						System.out.println("\n\t�La persona fue encontrada con �xito!");
					else
						System.out.println("\n\t�La persona no existe!");
				} catch (ColaVacia e) {
					System.out.println("La cola est� vac�a");
				}

				break;
			case 7:
				System.out.println("Programa finalizado..!");
				break;
			default:
				System.out.println("Elija una opcion del menu");
				break;
			}

		} while (opcion != 7);

	}

	public static void mostrarMenu() {
		System.out.println("-----------------MENU-------------------" + "\n1. Encolar \n" + "2. Desencolar \n"
				+ "3. Imprimir cola \n" + "4. Mostrar el Dato Mayor de la cola \n"
				+ "5. Mostrar el Dato menor de la cola\n" + "6. Buscar persona\n" + "7. Salir\n"
				+ "----------------------------------------\n");
		System.out.println("Ingrese el n�mero de una opci�n");
	}
}
