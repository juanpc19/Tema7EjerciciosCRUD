package ejercicio4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String dni = "";

		String nombre = "";

		double saldo;

		double dineroSolicitado;

		double dineroIngresar;

		int seleccionUsuario = 0;

		Scanner dogma = new Scanner(System.in);

		CuentaCorriente cuentas[] = new CuentaCorriente[0];

		while (seleccionUsuario != 5) {

			System.out.println("Seleccione una opcion.\n1.Crear cuenta.\n2.Sacar dinero.\n3.Ingresar dinero."
					+ "\n4.Mostrar datos de cuenta.\n5.Cerrar programa.");
			seleccionUsuario = dogma.nextInt();
			dogma.nextLine();

			switch (seleccionUsuario) {

			// crear cuenta
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
					System.out.println("Algun dato introducido es erroneo, repita la operacion.");
				}

			}

			// sacar dinero
			case 2 -> {
				System.out.println("Introduzca DNI para localizar la cuenta:");
				dni = dogma.nextLine();
				System.err.println("Introduzca cantidad de dinero a extraer de la cuenta:");
				dineroSolicitado = dogma.nextInt();

				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas) && dineroSolicitado >= 0) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].sacarDinero(dineroSolicitado);

				} else {
					System.out.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// ingresar dinero
			case 3 -> {
				System.out.println("Introduzca DNI para localizar la cuenta:");
				dni = dogma.nextLine();
				System.err.println("Introduzca cantidad de dinero a ingresar de la cuenta:");
				dineroIngresar = dogma.nextInt();

				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas) && dineroIngresar >= 0) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].ingresarDinero(dineroIngresar);

				} else {
					System.out.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// mostrar datos cuenta
			case 4 -> {
				System.out.println("Introduzca DNI para localizar la cuenta:");
				dni = dogma.nextLine();

				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas)) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].mostrarInformacion();

				} else {
					System.out.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// si seleccionUsuario igual a 5 cierro el programa
			case 5 -> {
				// comunico cierre de programa con mensaje por pantalla
				System.out.println("Cerrando programa...");
			}

			default -> {
				// muestro mensaje de error por pantalla indicando opciones correctas
				System.out.println("Asegurese de seleccionar una opcion entre el 1 y el 5 incluidos.");
				System.out.println();
			}

			}
		}

		//cierro escaner
		dogma.close();
	}

}
