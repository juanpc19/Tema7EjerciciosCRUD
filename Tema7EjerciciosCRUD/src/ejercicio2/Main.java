package ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// para el ejercicio presupongo que codigo es unico y no se puede cambiar o usar
		// de nuevo, a no ser que el articulo sea borrado junto a su codigo
		// precioCompra y entrada de mercancia hacen referencia a una compra al por
		// mayor, mientras que precioVenta y salida de mercancia hacen referencia a una
		// venta a un cliente en la tienda
		// alta hace referencia a la creacion de nuevo articulo
		// baja hace referencia al borrado de un articulo existente
		// modificacion solo afecta a descripcion preciocrompra y precio venta

		// creo escaner lo nombro dogma
		Scanner dogma = new Scanner(System.in);

		int seleccionUsuario = 0;// guardara opcion seleccionada por usuario para el CRUD

		String codigoUsuario = "";// guardara codigo proporcionado por usuario

		String descripcion;// guardara valor para descripcion para pasar como parametro de entrada a setter

		double precioCompra;// guardara valor para precioCompra para pasar como parametro de entrada a
							// setter

		double precioVenta;// guardara valor para precioVenta para pasar como parametro de entrada a setter

		int stock;// guardara valor para stock para pasar como parametro de entrada a setter

		int incremento = 0;// guardara valor para incremento para pasar como parametro de entrada a metodo
							// incrementarStock

		int decremento = 0;// guardara valor para decremento para pasar como parametro de entrada a metodo
							// decrementarStock

		// creo array articulo tipo Gestisimal que guardara 10 objetos
		Gestisimal articulo[] = new Gestisimal[10];

		// bucle que creara tantas variables tipo Gestisimal como longitud tenga array
		// el articulo, usara el contructor por defecto para ello y las ira guardando en
		// las posiciones del array articulo
		for (int i = 0; i < articulo.length; i++) {
			articulo[i] = new Gestisimal();
		}

		// muestro el menu del CRUD por pantalla
		// el bucle se ejecutara mientras seleccionUsuario sea diferente a 7
		do {
			System.out.println(
					"1.Listado.\n2.Alta.\n3.Baja.\n4.Modificacion.\n5.Entrada de mercancia.\n6.Salida de mercancia\n7.Salir");

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
				for (int i = 0; i < articulo.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de codigo
					// devuelva valor diferente a null
					if (!articulo[i].getCodigo().equals("vacio")) {
						// muestro la informacion del objeto por pantalla con ayuda del metodo toString
						System.out.println(articulo[i].toString());
					}
				}
			}

			// si seleccionUsuario igual a 2 creo un nuevo articulo en el array
			case 2 -> {
				// recorro el array articulo
				for (int i = 0; i < articulo.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de codigo
					// devuelva valor igual a null
					if (articulo[i].getCodigo().equals("vacio")) {

						// solicito datos para articulo
						System.out.println("Introduzca los datos del articulo que desea dar de alta.");

						// solicito valor para descripcion al usuario
						System.out.println("Introduzca descripcion del articulo:");
						// recojo valor con escaner y lo asigno a descripcion
						descripcion = dogma.nextLine();

						// solicito valor para precioCompra al usuario
						System.out.println("Introduzca precio de compra del articulo:");
						// recojo valor con escaner y lo asigno a precioCompra
						precioCompra = dogma.nextDouble();

						// solicito valor para precioVenta al usuario
						System.out.println("Introduzca precio de venta del articulo:");
						// recojo valor con escaner y lo asigno a precioVenta
						precioVenta = dogma.nextDouble();

						// solicito valor para stock al usuario
						System.out.println("Introduzca stock del articulo:");
						// recojo valor con escaner y lo asigno a stock
						stock = dogma.nextInt();
						// consumo linea con escaner para evitar error en siguiente escaner al cambiar
						// tipo de lectura
						dogma.nextLine();

						// una vez comprobado que todos los valores son correctos
						if (precioCompra > 0.0 && precioVenta > 0.0 && stock >= 0) {

							// uso los setter correspondientes con los argumentos proporcionados por el
							// usuario modificando los valores de los atributos del objeto en posicion
							// actual
							articulo[i].setDescripcion(descripcion);
							articulo[i].setPrecioCompra(precioCompra);
							articulo[i].setPrecioVenta(precioVenta);
							articulo[i].setStock(stock);

							// y le doy al setter de codigo del objeto en posicion actual el valor de
							// i, uso Integer.toString para pasar i de int a String
							articulo[i].setCodigo(Integer.toString(i));

							// comunico creacion articulo con mensaje por pantalla
							System.out.println("Articulo creado con exito.");
						}
						// una vez creado el articulo hago break para forzar salida del bucle
						break;
					}
				}
			}

			// si seleccionUsuario igual a 3 borro un articulo del array
			case 3 -> {
				// solicito codigo de articulo a borrar
				System.out.println("Introduzca el codigo del articulo que desea dar de baja.");
				// recojo valor con escaner y lo asigno a codigoUsuario
				codigoUsuario = dogma.nextLine();

				// recorro el array articulo
				for (int i = 0; i < articulo.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de codigo
					// devuelva valor igual a codigoUsuario
					if (articulo[i].getCodigo().equals(codigoUsuario)) {
						// procedo a modificar su atributo codigo con el setter de codigo argumento a
						// null
						articulo[i].setCodigo("vacio");

						// comunico borrado articulo con mensaje por pantalla
						System.out.println("Articulo borrado con exito.");

						// una vez borrado el articulo hago break para forzar salida del bucle
						break;
					}
				}
			}

			// si seleccionUsuario igual a 4 modifico un articulo del array
			case 4 -> {
				// solicito codigo de articulo a modificar
				System.out.println("Introduzca el codigo del articulo que desea modificar.");
				// recojo valor con escaner y lo asigno a codigoUsuario
				codigoUsuario = dogma.nextLine();

				// recorro el array articulo
				for (int i = 0; i < articulo.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de codigo
					// devuelva valor igual a codigoUsuario
					if (articulo[i].getCodigo().equals(codigoUsuario)) {

						// solicito datos para articulo
						System.out.println("Introduzca los datos del articulo que desea modificar.");

						// solicito valor para descripcion al usuario
						System.out.println("Introduzca descripcion del articulo:");
						// recojo valor con escaner y lo asigno a descripcion
						descripcion = dogma.nextLine();

						// solicito valor para precioCompra al usuario
						System.out.println("Introduzca precio de compra del articulo:");
						// recojo valor con escaner y lo asigno a precioCompra
						precioCompra = dogma.nextDouble();

						// solicito valor para precioVenta al usuario
						System.out.println("Introduzca precio de venta del articulo:");
						// recojo valor con escaner y lo asigno a precioVenta
						precioVenta = dogma.nextDouble();

						// solicito valor para stock al usuario
						System.out.println("Introduzca stock del articulo:");
						// recojo valor con escaner y lo asigno a stock
						stock = dogma.nextInt();
						// consumo linea con escaner para evitar error en siguiente escaner al cambiar
						// tipo de lectura
						dogma.nextLine();

						// una vez comprobado que todos los valores son correctos
						if (precioCompra > 0.0 && precioVenta > 0.0 && stock >= 0) {

							// uso los setter correspondientes con los argumentos proporcionados por el
							// usuario modificando los valores de los atributos del objeto en posicion
							// actual
							articulo[i].setDescripcion(descripcion);
							articulo[i].setPrecioCompra(precioCompra);
							articulo[i].setPrecioVenta(precioVenta);
							articulo[i].setStock(stock);

							// comunico modificacion articulo con mensaje por pantalla
							System.out.println("Articulo modificado con exito.");
						}
						// una vez modificado el articulo hago break para forzar salida del bucle
						break;
					}
				}
			}

			// si seleccionUsuario igual a 5 incremento el stock de un articulo
			case 5 -> {
				// solicito codigo de articulo cuyo stock hay que incrementar
				System.out.println("Introduzca el codigo del articulo cuyo stock desea aumentar.");
				// recojo valor con escaner y lo asigno a codigoUsuario
				codigoUsuario = dogma.nextLine();

				// recorro el array articulo
				for (int i = 0; i < articulo.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de codigo
					// devuelva valor igual a codigoUsuario
					if (articulo[i].getCodigo().equals(codigoUsuario)) {
						// solicito valor para incremento
						System.out.println("Introduzca cantidad en la que aumentar el stock.");
						// recojo valor con escaner y lo asigno a incremento
						incremento = dogma.nextInt();
						// consumo linea con escaner para evitar error en siguiente escaner al cambiar
						// tipo de lectura
						dogma.nextLine();
						// aumento valor del atributo stock del articulo en cuestion usando metodo
						// incrementarStock con argumento incremento
						articulo[i].incrementarStock(incremento);
						System.out.println("Stock del articulo incrementado con exito.");
						// una vez incrementado el stock del articulo hago break para forzar salida del
						// bucle
						break;
					}
				}
			}

			// si seleccionUsuario igual a 6 decremento el stock de un articulo
			case 6 -> {
				// solicito codigo de articulo cuyo stock hay que decrementar
				System.out.println("Introduzca el codigo del articulo cuyo stock desea decrementar.");
				// recojo valor con escaner y lo asigno a codigoUsuario
				codigoUsuario = dogma.nextLine();

				// recorro el array articulo
				for (int i = 0; i < articulo.length; i++) {
					// cuando encuentre un objeto en posicion actual del array cuyo getter de codigo
					// devuelva valor igual a codigoUsuario
					if (articulo[i].getCodigo().equals(codigoUsuario)) {
						// solicito valor para decremento
						System.out.println("Introduzca cantidad en la que decrementar el stock.");
						// recojo valor con escaner y lo asigno a decremento
						decremento = dogma.nextInt();
						if (decremento <= articulo[i].getStock()) {
							// consumo linea con escaner para evitar error en siguiente escaner al cambiar
							// tipo de lectura
							dogma.nextLine();
							// disminuyo valor del atributo stock del articulo en cuestion usando metodo
							// decrementarStock con argumento decremento
							articulo[i].decrementarStock(decremento);
							System.out.println("Stock del articulo decrementado con exito.");
							// una vez decrementado el stock del articulo hago break para forzar salida del
							// bucle
							break;
						}
					}
				}
			}

			// si seleccionUsuario igual a 7
			case 7 -> {
				// comunico cierre de programa con mensaje por pantalla
				System.out.println("Cerrando programa...");
			}

			// si seleccionUsuario igual a diferente a todos los case esperados
			default -> {
				// muestro mensaje de error por pantalla indicando opciones correctas
				System.out.println("Asegurese de seleccionar una opcion entre el 1 y el 7 incluidos.");
				System.out.println();
			}
			}
			// el bucle se ejecutara mientras seleccionUsuario sea diferente a 7
		} while (seleccionUsuario != 7);

		// cierro escaner
		dogma.close();
	}

}
