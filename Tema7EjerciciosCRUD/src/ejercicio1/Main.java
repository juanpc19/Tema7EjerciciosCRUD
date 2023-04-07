package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// creo escaner lo nombro dogma
		Scanner dogma = new Scanner(System.in);

		int seleccionUsuario = 0;// guardara opcion seleccionada por usuario para el CRUD

		String nombre = "";// guardara valor para nombre para pasar como parametro de entrada a setter

		double notaMedia;// guardara valor para notaMedia para pasar como parametro de entrada a setter

		// creo array alumnos tipo Alumno que guardara 30 objetos
		Alumno alumnos[] = new Alumno[30];

		// bucle que creara 30 variables tipo Alumno con el contructor por defecto y las
		// ira guardando en las posiciones del array alumnos
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i] = new Alumno();
		}

		// muestro el menu del CRUD por pantalla
		// el bucle se ejecutara mientras seleccionUsuario sea diferente a 5
		do {
			System.out.println(
					"ALUMNOS/AS \n--------------------\n--------------------\n1.Listado.\n2.Nuevo Alumno.\n3.Modificar.\n4.Borrar.\n5.Salir");

			// recojo seleccione de usuario y lo asigno a seleccionUsuario con escaner
			seleccionUsuario = dogma.nextInt();
			// consumo linea con escaner para evitar error en siguiente escaner al cambiar
			// tipo de lectura
			dogma.nextLine();

			// hago evaluacion de seleccionUsuario con switch
			switch (seleccionUsuario) {

			// si seleccionUsuario igual a 1
			case 1 -> {
				// recorro el array alumnos
				for (int i = 0; i < alumnos.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de nombre
					// devuelva valor diferente a null
					if (alumnos[i].getNombre() != null) {
						// muestro la informacion del objeto por pantalla con ayuda del metodo toString
						System.out.println(alumnos[i].toString());
					}
				}
			}

			// si seleccionUsuario igual a 2
			case 2 -> {

				// solicito a usuario valor para nombre
				System.out.println("Introduzca nombre y apellidos del alumno: ");
				// recojo valor de usuario y lo asigno a nombre con escaner
				nombre = dogma.nextLine();

				// solicito a usuario valor para notaMedia
				System.out.println("Introduzca nota media del alumno: ");
				// recojo valor de usuario y lo asigno a notaMedia con escaner
				notaMedia = dogma.nextDouble();

				// si notaMedia tiene valor menor a 0.0 es un valor incorrecto
				if (notaMedia < 0.0) {
					// por lo que lo comunico con mensaje por pantalla al usuario
					System.out.println(
							"Ha introducido una nota negativa que no se asignara al alumno, repita el proceso");
					// si el valor introducido paa notaMedia es valido
				} else {
					// recorro el array alumnos
					for (int i = 0; i < alumnos.length; i++) {
						// y al encontrar el primer objeto del array cuyo getter de nombre devuelva null
						if (alumnos[i].getNombre() == null) {
							// modifico su nombre dandole al setter de nombre el argumento nombre
							alumnos[i].setNombre(nombre);
							// y modifico su notaMedia dandole al setter de notaMedia el argumento notaMedia
							alumnos[i].setNotaMedia(notaMedia);
							// hago break para salir del case que ya ha cumplido su funcion
							break;
						}
					}
				}
			}

			// si seleccionUsuario igual a 3
			case 3 -> {
				// solicito a usuario valor para nombre
				System.out.println("Introduzca nombre y apellidos del alumno cuya nota desea modificar: ");
				// recojo valor de usuario y lo asigno a nombre con escaner
				nombre = dogma.nextLine();

				// recorro el array alumnos
				for (int i = 0; i < alumnos.length; i++) {
					// y si encuentro un objeto en el array cuyo getter de nombre devuelva valor
					// igual a nombre procedo a modificar dicho objeto con nuevos valores del
					// usuario
					if (alumnos[i].getNombre().equals(nombre)) {
						// solicito a usuario valor para notaMedia
						System.out.println("Introduzca nueva nota media del alumno: ");
						// recojo valor de usuario y lo asigno a notaMedia con escaner
						notaMedia = dogma.nextDouble();
						// si notaMedia tiene valor menor a 0.0 es un valor incorrecto
						if (notaMedia < 0.0) {
							// por lo que lo comunico con mensaje por pantalla al usuario
							System.out.println(
									"Ha introducido una nota negativa que no se asignara al alumno, repita el proceso");
							// si el valor para notaMedia es valido
						} else {
							// modifico su notaMedia dandole al setter de notaMedia el argumento notaMedia
							alumnos[i].setNotaMedia(notaMedia);
						}
						// hago break para salir del case que ya ha cumplido su funcion
						break;
					}
				}
			}

			// si seleccionUsuario igual a 4
			case 4 -> {
				// solicito a usuario valor para nombre
				System.out.println("Introduzca nombre y apellidos del alumno cuyos datos desea borrar: ");
				// recojo valor de usuario y lo asigno a nombre con escaner
				nombre = dogma.nextLine();
				// recorro array alumnos
				for (int i = 0; i < alumnos.length; i++) {
					// y si encuentro un objeto en el array cuyo getter de nombre devuelva valor
					// igual a nombre
					if (alumnos[i].getNombre().equals(nombre)) {
						// procedo a modificar su nombre con valor igual a null
						alumnos[i].setNombre(null);
						// hago break para salir del case que ya ha cumplido su funcion
						break;
					}
				}
			}

			// si seleccionUsuario igual a 5
			case 5 -> {
				// comunico cierre de programa con mensaje por pantalla
				System.out.println("Cerrando programa...");
			}

			// si seleccionUsuario es un valor no esperado
			default -> {
				// muestro mensaje de error por pantalla indicando opciones correctas
				System.out.println("Asegurese de seleccionar una opcion entre el 1 y el 5 incluidos.");
				System.out.println();
			}

			}

			// el bucle se ejecutara mientras seleccionUsuario sea diferente a 5
		} while (seleccionUsuario != 5);

		// cierro escaner
		dogma.close();
	}

}
