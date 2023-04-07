package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner dogma = new Scanner(System.in);

		int seleccionUsuario = 0;

		String nombre = "";

		double notaMedia;

		Alumno alumnos[] = new Alumno[30];

		// bucle que creara 30 variables tipo Alumno con el contructor por defecto y las
		// ira guardando en las posiciones del array alumnos
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i] = new Alumno();
		}

		do {
			System.out.println(
					"ALUMNOS/AS \n--------------------\n--------------------\n1.Listado.\n2.Nuevo Alumno.\n3.Modificar.\n4.Borrar.\n5.Salir");

			seleccionUsuario = dogma.nextInt();
			dogma.nextLine();

			switch (seleccionUsuario) {

			case 1 -> {
				for (int i = 0; i < alumnos.length; i++) {

					if (alumnos[i].getNombre() != null) {
						System.out.println(alumnos[i].toString());

					}
				}
			}

			case 2 -> {

				System.out.println("Introduzca nombre y apellidos del alumno: ");
				nombre = dogma.nextLine();

				System.out.println("Introduzca nota media del alumno: ");
				notaMedia = dogma.nextDouble();
				if (notaMedia < 0.0) {
					System.out.println(
							"Ha introducido una nota negativa que no se asignara al alumno, repita el proceso");
				} else {

					for (int i = 0; i < alumnos.length; i++) {

						if (alumnos[i].getNombre() == null) {
							alumnos[i].setNombre(nombre);
							alumnos[i].setNotaMedia(notaMedia);
							break;
						}
					}
				}
			}

			case 3 -> {
				System.out.println("Introduzca nombre y apellidos del alumno cuya nota desea modificar: ");
				nombre = dogma.nextLine();

				for (int i = 0; i < alumnos.length; i++) {

					if (alumnos[i].getNombre().equals(nombre)) {
						System.out.println("Introduzca nuevo valor para la nota media a modificar: ");
						notaMedia = dogma.nextDouble();
						if (notaMedia < 0.0) {
							System.out.println(
									"Ha introducido una nota negativa que no se asignara al alumno, repita el proceso");
						} else {
							alumnos[i].setNotaMedia(notaMedia);
						}
						break;
					}
				}
			}

			case 4 -> {
				System.out.println("Introduzca nombre y apellidos del alumno cuyos datos desea borrar: ");
				nombre = dogma.nextLine();

				for (int i = 0; i < alumnos.length; i++) {

					if (alumnos[i].getNombre().equals(nombre)) {
						alumnos[i].setNombre(null);
						break;
					}
				}
			}

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

		} while (seleccionUsuario != 5);
		dogma.close();

	}

}
