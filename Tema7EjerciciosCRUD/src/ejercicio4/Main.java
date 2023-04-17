package ejercicio4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String dni = "";//guardara valor para dni

		String nombre = "";//guardara valor para nombre

		double saldo;//guardara valor para saldo

		double dineroSolicitado;//guardara dinero a extraer de la cuenta

		double dineroIngresar;//guardara dinero a ingresar en la cuenta 

		int seleccionUsuario = 0;//guardara la seleccion del usuario, inicializo a 0 para uso en bucle

		//creo escaner y lo llamo dogma
		Scanner dogma = new Scanner(System.in);

		CuentaCorriente cuentas[] = new CuentaCorriente[0];// creo array cuentas tipo CuentaCorriente de longitud 0
															// guardara las cuentas

		//bucle que ejecutara el menu mientras seleccion de usuario sea diferente a  5
		while (seleccionUsuario != 5) {

			//muestro menu por pantalla
			System.out.println("Seleccione una opcion.\n1.Crear cuenta.\n2.Sacar dinero.\n3.Ingresar dinero."
					+ "\n4.Mostrar datos de cuenta.\n5.Cerrar programa.");
			//reocojo seleccion usuario con escaner y lo a asigno a seleccionUsuario
			seleccionUsuario = dogma.nextInt();
			//consumo lineacon escaner para evitar falo de lectura
			dogma.nextLine();

			//switch que evaluara a seleccionUusario
			switch (seleccionUsuario) {

			// si seleccionUsuario igual a 1 creo cuenta
			case 1 -> {

				System.out.println("Introduzca su dni: ");
				dni = dogma.nextLine();

				System.out.println("Introduzca su nombre: ");
				nombre = dogma.nextLine();

				System.out.println("Introduzca su saldo: ");
				saldo = dogma.nextInt();

				if (dni.length() == 9 && saldo >= 0 && CuentaCorriente.compruebaDniUsado(dni, cuentas) == false) {
					cuentas = Arrays.copyOf(cuentas, cuentas.length + 1);
					cuentas[cuentas.length - 1] = new CuentaCorriente(dni, nombre, saldo);

				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}

			}

			// si seleccionUsuario igual a 2 saco dinero de una cuenta
			case 2 -> {
				System.out.println("Introduzca DNI para localizar la cuenta:");
				dni = dogma.nextLine();
				System.out.println("Introduzca cantidad de dinero a extraer de la cuenta:");
				dineroSolicitado = dogma.nextInt();

				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas) && dineroSolicitado >= 0) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].sacarDinero(dineroSolicitado);

				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// si seleccionUsuario igual a 3 ingreso dinero en una cuenta
			case 3 -> {
				System.out.println("Introduzca DNI para localizar la cuenta:");
				dni = dogma.nextLine();
				System.out.println("Introduzca cantidad de dinero a ingresar de la cuenta:");
				dineroIngresar = dogma.nextInt();

				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas) && dineroIngresar >= 0) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].ingresarDinero(dineroIngresar);

				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// si seleccionUsuario igual a 4 muestro datos de una cuenta
			case 4 -> {
				System.out.println("Introduzca DNI para localizar la cuenta:");
				dni = dogma.nextLine();

				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas)) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].mostrarInformacion();

				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// si seleccionUsuario igual a 5 cierro el programa
			case 5 -> {
				// comunico cierre de programa con mensaje por pantalla
				System.out.println("Cerrando programa...");
			}

			default -> {
				// muestro mensaje de error por pantalla indicando opciones correctas
				System.err.println("Asegurese de seleccionar una opcion entre el 1 y el 5 incluidos.");
				System.out.println();
			}
			}
		}

		// cierro escaner
		dogma.close();
	}

}
