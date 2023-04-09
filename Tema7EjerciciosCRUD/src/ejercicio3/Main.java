package ejercicio3;

import java.util.Arrays;
import java.util.Scanner;

import ejercicio3.Pizza.Estado;
import ejercicio3.Pizza.Tamaño;
import ejercicio3.Pizza.Tipo;

public class Main {

	public static void main(String[] args) {

		// creo escaner y lo nombro dogma
		Scanner dogma = new Scanner(System.in);

		int seleccionUsuario = 0;// guardara opcion seleccionada por usuario para el CRUD

		String tamaño = "";// guardara valor para tamaño para pasar como parametro de entrada a setter

		String tipo = "";// guardara valor para tipo para pasar como parametro de entrada a setter

		int codigo;// guardara valor para codigo para pasar como parametro de entrada a setter

		int codigoUsuario;// guardara valor para codigoUsuario para realizar busqueda en lista de pedidos

		// creo array pedidos tipo Pizza que guardara 0 objetos
		Pizza pedidos[] = new Pizza[0];

		// bloque de instrucciones que se ejecutara mientras opcionUsuario sea diferente
		// a 4
		do {
			// muestro mensaje por pantalla con el menu de opciones
			System.out.println("1.Listado de pizzas.\n2.Nuevo pedido.\n3.Pizza servida.\n4.Salir.");

			// recojo seleccion de usuario y lo asigno a seleccionUsuario con escaner
			seleccionUsuario = dogma.nextInt();
			// consumo linea con escaner para evitar error en siguiente escaner al cambiar
			// tipo de lectura
			dogma.nextLine();

			// hago evaluacion de seleccionUsuario con switch
			switch (seleccionUsuario) {

			// si seleccionUsuario igual a 1 muestro el Listado de pizzas
			case 1 -> {
				// recorriendo el array con bucle for
				for (int i = 0; i < pedidos.length; i++) {
					// comprobando si el getter de codigo de objeto en posicion actual devuelve un
					// valor igual o mayor a 0
					if (pedidos[i].getCodigo() >= 0) {
						// en cuyo caso lo muestro en mensaje por pantalla
						System.out.println(pedidos[i].toString());
					}
				}
			}

			// si seleccionUsuario igual a 2 creo y añado pedido a la lista
			case 2 -> {
				// creo una posicion el array pedidos para el nuevo pedido
				pedidos = Arrays.copyOf(pedidos, pedidos.length + 1);
				// creo un objeto tipo pedidos en la ultima posicion del array
				pedidos[pedidos.length - 1] = new Pizza();

				// le doy a codigo valor igual a ultima posicion del array pedidos
				codigo = pedidos.length - 1;
				// uso dicho codigo como parametro de entrada en el setter del objeto pedidos en
				// ultima posicion del array
				pedidos[pedidos.length - 1].setCodigo(codigo);

				// solicito valor para tamaño
				System.out.print("Introduzca tamaño de pizza: ");
				// mostrando a usuario valores disponibles para tamaño con un bucle for each que
				// recorrera los valores del enum Tamaño mostrandolos por pantalla
				for (Tamaño t : Tamaño.values()) {
					System.out.print("|" + t + "|");
				}
				// recogo valor de usuario con escaner y lo asigno a tamaño
				tamaño = dogma.nextLine();
				// lo paso a mayusculas para comprar con valores de enum Tamaño
				tamaño = tamaño.toUpperCase();
				// si el metodo contieneTamaño con parametro de entrada tamaño devuelve true
				if (Pizza.contieneTamaño(tamaño)) {
					// tamaño contiene un valor correcto por lo que lo asigno al objeto en la ultima
					// posicion del array con su setter aplicandole un valueOf para pasar su valor a
					// tipo Tamaño
					pedidos[pedidos.length - 1].setTamaño(Tamaño.valueOf(tamaño));
					// de lo contrario comunico error con mensaje por pantalla
				} else {
					System.out.print("Tamaño incorrecto.");
				}
				// solicito valor para tamaño
				System.out.println("Introduzca tipo de pizza: ");
				// mostrando a usuario valores disponibles para tipo con un bucle for each que
				// recorrera los valores del enum Tipo mostrandolos por pantalla
				for (Tipo t : Tipo.values()) {
					System.out.print("|" + t + "|");
				}
				// recogo valor de usuario con escaner y lo asigno a tipo
				tipo = dogma.nextLine();
				// lo paso a mayusculas para comprar con valores de enum Tipo
				tipo = tipo.toUpperCase();
				// si el metodo contieneTipo con parametro de entrada tipo devuelve true
				if (Pizza.contieneTipo(tipo)) {
					// tipo contiene un valor correcto por lo que lo asigno al objeto en la ultima
					// posicion del array con su setter aplicandole un valueOf para pasar su valor a
					// tipo Tipo
					pedidos[pedidos.length - 1].setTipo(Tipo.valueOf(tipo));
					// de lo contrario comunico error con mensaje por pantalla
				} else {
					System.out.println("Tipo incorrecto.");
				}

				// le doy al objeto pedidos en ultima posicion del array valor en su atributo
				// estado igual a PEDIDA usando su setter
				pedidos[pedidos.length - 1].setEstado(Estado.PEDIDA);

			}

			// si seleccionUsuario igual a 3 cambio el estado de la pizza en cuestion
			case 3 -> {
				// solicito a usuario codigo de pedido a modificar
				System.out.println("Introduzca codigo de la pizza que ha servido:");
				// recojo valor con escaner y lo asigno a codigoUsuario
				codigoUsuario = dogma.nextInt();
				// recorreo el array buscando el codigo proporcionado por el usuario
				for (int i = 0; i < pedidos.length; i++) {
					// si codigoUsuario tiene valor igual a posicion actual dentro del array el
					// codigo es correcto
					if (codigoUsuario == i) {
						// por lo que modifico atributo estado del pedido en esa posicion a SERVIDA con
						// su setter
						pedidos[codigoUsuario].setEstado(Estado.SERVIDA);
						// y hago break para evitar iteraciones innecesarias
						break;
					}
					// si no encuentro una posicion de valor igual a codigoUsuario en el array lo
					// comunico con mensaje
					System.out.println("Codigo no encontrado en la lista.");
				}
			}

			// si seleccionUsuario igual a 4 cierro el programa
			case 4 -> {
				// comunico cierre de programa con mensaje por pantalla
				System.out.println("Cerrando programa...");
			}

			// si seleccionUsuario igual a diferente a todos los case esperados
			default -> {
				// muestro mensaje de error por pantalla indicando opciones correctas
				System.out.println("Asegurese de seleccionar una opcion entre el 1 y el 4 incluidos.");
				System.out.println();
			}
			}
			// el bucle se ejecutara mientras seleccionUsuario sea diferente a 4
		} while (seleccionUsuario != 4);

		// cierro escaner
		dogma.close();
	}

}
