package ejercicio4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String dni = "";// guardara valor para dni

		String nombre = "";// guardara valor para nombre

		double saldo;// guardara valor para saldo

		double dineroSolicitado;// guardara dinero a extraer de la cuenta

		double dineroIngresar;// guardara dinero a ingresar en la cuenta

		int seleccionUsuario = 0;// guardara la seleccion del usuario, inicializo a 0 para uso en bucle

		// creo escaner y lo llamo dogma
		Scanner dogma = new Scanner(System.in);

		CuentaCorriente cuentas[] = new CuentaCorriente[0];// creo array cuentas tipo CuentaCorriente de longitud 0
															// guardara las cuentas

		// bucle que ejecutara el menu mientras seleccion de usuario sea diferente a 5
		while (seleccionUsuario != 5) {

			// muestro menu por pantalla
			System.out.println("Seleccione una opcion.\n1.Crear cuenta.\n2.Sacar dinero.\n3.Ingresar dinero."
					+ "\n4.Mostrar datos de cuenta.\n5.Cerrar programa.");
			// reocojo seleccion usuario con escaner y lo a asigno a seleccionUsuario
			seleccionUsuario = dogma.nextInt();
			// consumo lineacon escaner para evitar falo de lectura
			dogma.nextLine();

			// switch que evaluara a seleccionUusario
			switch (seleccionUsuario) {

			// si seleccionUsuario igual a 1 creo cuenta
			case 1 -> {
				// solicito dni a usuario
				System.out.println("Introduzca su dni: ");
				// recojo valor y lo asigno a dni con escaner
				dni = dogma.nextLine();

				// solicito nombre a usuario
				System.out.println("Introduzca su nombre: ");
				// recojo valor y lo asigno a nombre con escaner
				nombre = dogma.nextLine();

				// solicito saldo a usuario
				System.out.println("Introduzca su saldo: ");
				// recojo valor y lo asigno a saldo con escaner
				saldo = dogma.nextInt();

				// compruebo que los datos con correctos (dni tiene 9 caracteres, saldo es mayor
				// o igual a 0 y dni no ha sido usado)
				if (dni.length() == 9 && saldo >= 0 && CuentaCorriente.compruebaDniUsado(dni, cuentas) == false) {
					// si todo esta correcto extiendo la longitud del array cuentas en +1
					cuentas = Arrays.copyOf(cuentas, cuentas.length + 1);
					// y creo un objeto tipoCuentaCorriente con los datos del usuario en la ultima
					// posicion del array cuentas
					cuentas[cuentas.length - 1] = new CuentaCorriente(dni, nombre, saldo);

					// si los datos son incorrectos lo comunico con mensaje por pantalla
				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}

			}

			// si seleccionUsuario igual a 2 saco dinero de una cuenta
			case 2 -> {
				// solicito dni a usuario
				System.out.println("Introduzca su dni: ");
				// recojo valor y lo asigno a dni con escaner
				dni = dogma.nextLine();

				// solicito dineroSolicitado a usuario
				System.out.println("Introduzca cantidad de dinero a extraer de la cuenta:");
				// recojo valor y lo asigno a dineroSolicitado con escaner
				dineroSolicitado = dogma.nextInt();

				// compruebo que los datos con correctos (dni tiene 9 caracteres, dni no ha sido
				// usado y dineroSolicitado mayor o igual a 0)
				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas) && dineroSolicitado >= 0) {
					// en cuyo caso llamo al metodo estatico numeroCuenta con parametros de entrada
					// dni y cuentas, esto me devolvera un int que usare para determinar en que
					// posicion del array cuentas llamare al metodo sacarDinero con el parametro de
					// entrada dineroSolicitado
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].sacarDinero(dineroSolicitado);

					// si los datos son incorrectos lo comunico con mensaje por pantalla
				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// si seleccionUsuario igual a 3 ingreso dinero en una cuenta
			case 3 -> {
				// solicito dni a usuario
				System.out.println("Introduzca su dni: ");
				// recojo valor y lo asigno a dni con escaner
				dni = dogma.nextLine();

				// solicito dineroIngresar a usuario
				System.out.println("Introduzca cantidad de dinero a ingresar de la cuenta:");
				// recojo valor y lo asigno a dineroIngresar con escaner
				dineroIngresar = dogma.nextInt();

				// compruebo que los datos con correctos (dni tiene 9 caracteres, dni no ha sido
				// usado y dineroIngresar mayor o igual a 0)
				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas) && dineroIngresar >= 0) {
					// en cuyo caso llamo al metodo estatico numeroCuenta con parametros de entrada
					// dni y cuentas, esto me devolvera un int que usare para determinar en que
					// posicion del array cuentas llamare al metodo ingresarDinero con el parametro
					// de
					// entrada dineroIngresar
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].ingresarDinero(dineroIngresar);

					// si los datos son incorrectos lo comunico con mensaje por pantalla
				} else {
					System.err.println("Algun dato introducido es erroneo, repita la operacion.");
				}
			}

			// si seleccionUsuario igual a 4 muestro datos de una cuenta
			case 4 -> {
				// solicito dni a usuario
				System.out.println("Introduzca su dni: ");
				// recojo valor y lo asigno a dni con escaner
				dni = dogma.nextLine();

				// compruebo que los datos con correctos (dni tiene 9 caracteres, dni no ha sido
				// usado)
				if (dni.length() == 9 && CuentaCorriente.compruebaDniUsado(dni, cuentas)) {
					cuentas[CuentaCorriente.numeroCuenta(dni, cuentas)].mostrarInformacion();

					// si los datos son incorrectos lo comunico con mensaje por pantalla
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
