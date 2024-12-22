package tallerPila;

import java.util.Scanner;

import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class ExpresionPosFija {

	public static void main(String[] args) {

		Pila<Integer> pila = new TadPila<>();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("INGRESE LA EXPRESION QUE VA A CALCULAR(EN ORDEN POSTFIJO):");
			String expresion = sc.nextLine();
			int resul = resolverExpresionPostFija(pila, expresion);
			if (pila.numElemPila() == 1)
				System.out.println("El resultado es:" + resul);
			else
				System.out.println("Existe un error, faltan operadores en la expresion");

			sc.close();
		} catch (PilaVacia e) {
			// TODO Auto-generated catch block
			System.out.println("Hay errores en la expresion ingresada");
		}
	}

	private static int resolverExpresionPostFija(Pila<Integer> pila, String expresion) throws PilaVacia {

		String[] proceso = expresion.split(" ");
		for (int i = 0; i < proceso.length; i++) {
			try {
				pila.apilar(Integer.valueOf(proceso[i]));
			} catch (NumberFormatException e) {
				int opd1 = pila.desapilar();
				int opd2 = pila.desapilar();
				switch (proceso[i]) {
				case "+":
					pila.apilar(opd2 + opd1);
					break;
				case "-":
					pila.apilar(opd2 - opd1);
					break;

				case "*":
					pila.apilar(opd2 * opd1);
					break;

				case "/":
					pila.apilar(opd2 / opd1);
					break;
				}
			}
		}
		return pila.cima();
	}

}
