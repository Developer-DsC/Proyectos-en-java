import java.io.IOException;
import Algoritmos.Persona;
import tad.TADTeclado;
import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class Probar_Pila {
	public static void main(String[] args) {

		Pila<Persona> pilaPersonas = new TadPila<Persona>("Personas");
		TADTeclado teclado = new TADTeclado();
		Persona persona;
		String nombre = "", cedula = "";
		int edad = 0;
		double peso = 0.0;
		int opcion = 0;

		pilaPersonas.apilar(new Persona("0705", "Joselyn", 21, 135.5));
		pilaPersonas.apilar(new Persona("0702", "Dylan", 19, 120.8));
		pilaPersonas.apilar(new Persona("0706", "Darwin", 22, 110.7));
		pilaPersonas.apilar(new Persona("0708", "Josue", 19, 115.1));
		pilaPersonas.apilar(new Persona("0709", "Maria", 17, 136.4));

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
				pilaPersonas.apilar(persona);

				break;
			case 2:
				try {
					pilaPersonas.decapitar();
				} catch (PilaVacia e) {
					System.out.println("desapitar: La pila est� vac�a");
				}

				break;
			case 3:
				pilaPersonas.imprimirPila();

				break;
			case 4:
				try {
					System.out.println("El dato mayor es: " + TadPila.verMayorPila(pilaPersonas));
				} catch (PilaVacia e) {
					System.out.println("La pila est� vac�a...");
				}

				break;
			case 5:
				try {
					System.out.println("El dato menor es: " + TadPila.verMenorPila(pilaPersonas));
				} catch (PilaVacia e) {
					System.out.println("La pila est� vac�a...");
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
					peso = teclado.leerDouble("Digite el peso de " + nombre);
				} catch (NumberFormatException | IOException e) {
					System.out.println("ERROR! el peso es un dato double");
				}

				persona = new Persona(cedula, nombre, edad, peso);

				try {
					if (TadPila.buscarDatoPila(pilaPersonas, persona))
						System.out.println("\n\t�La persona fue encontrada con �xito!");
					else
						System.out.println("\n\t�La persona no existe!");
				} catch (PilaVacia e) {
					System.out.println("La cola est� vac�a");
				}
				break;
			case 7:

				System.out.println("Programa finalizado");
				break;
			default:
				System.out.println("Elija una opcion del menu");
				break;
			}

		} while (opcion != 7);

	}

	public static void mostrarMenu() {
		System.out.println(
				"-----------------MENU-------------------" + "\n1. Apilar \n" + "2. Desapilar \n" + "3. Imprimir pila\n"
						+ "4. Mostrar el Dato Mayor de la pila\n" + "5. Mostrar el Dato menor de la pila\n"
						+ "6. Buscar persona \n" + "7. Salir\n" + "----------------------------------------\n");
		System.out.println("Ingrese el n�mero de una opci�n");
	}
}
