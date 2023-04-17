package ejercicio4;

/**
 * Clase Cuenta corriente que contiene metodos para realizar transacciones y ver
 * los datos de cuentas bancarias y localizarlas mediante atributo dni ademas de
 * comprobar si el dni se encuentra en la lista de cuentas
 * 
 * @author jperez
 *
 */
public class CuentaCorriente {

	private String dni;// atributo que guardara el dni

	private String nombre;// atributo que guardara el nombre

	private double saldo;// atributo que guardara el saldo

	/**
	 * constructor sin parametros de entrada
	 */
	public CuentaCorriente() {

	}

	/**
	 * constructor con datos de entrada
	 * 
	 * @param dni    guardara valor asignable a atributo dni
	 * @param nombre guardara valor asignable a atributo nombre
	 * @param saldo  guardara valor asignable a atributo saldo
	 */
	public CuentaCorriente(String dni, String nombre, double saldo) {
		// doy a atributo dni valor de parametro de entrada dni
		this.dni = dni;
		// doy a atributo nombre valor de parametro de entrada nombre
		this.nombre = nombre;
		// doy a atributo saldo valor de parametro de entrada saldo
		this.saldo = saldo;
	}

	/**
	 * getter de atributo dni
	 * 
	 * @return dni devolvera valor actual de atributo dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * metodo que sacara dinero si existe saldo suficiente para ello
	 * 
	 * @param dineroSolicitado guardara la cantidad de dinero a extraer
	 */
	public void sacarDinero(double dineroSolicitado) {
		// si el atributo saldo actual es mayor o igual que el dinero a extraer
		if (saldo >= dineroSolicitado) {
			// se llevara a cabo la extraccion restandole dineroSolicitado a atributo saldo
			saldo -= dineroSolicitado;
			// y se le comunicara al usuario mediante mensaje por pantalla
			System.out.println("Su transaccion es posible y se ha llevado a cabo. ");
			System.out.println();

			// de lo contrario no se llevara a cabo la operacion
			// y se le comunicara al usuario mediante mensaje por pantalla
		} else {
			System.out.println("Su transaccion no es posible, no tiene suficiente saldo. ");
			System.out.println();
		}
	}

	/**
	 * metodo que añadira el valor del dinero ingresado a saldo
	 * 
	 * @param dineroIngresar
	 */
	public void ingresarDinero(double dineroIngresar) {
		// añado el valor de dineroIngresar a atributo saldo
		saldo += dineroIngresar;
		// y se le comunica al usuario mediante mensaje por pantalla
		System.out.println("Su transaccion es posible y se ha llevado a cabo. ");
		System.out.println();
	}

	/**
	 * metodo que mostrara los datos de la cuenta especificada asociada con su
	 * propio objeto
	 */
	public void mostrarInformacion() {
		// print de pantalla de los atributos con los valores del objeto con el que se
		// usa el metodo
		System.out.println("La cuenta de: " + dni + " " + nombre + ", tiene " + saldo + " de saldo.");
		System.out.println();
	}

	/**
	 * metodo que comprobara si un dni se encuentra en el array cuentas tipo
	 * CuentaCorriente
	 * 
	 * @param dni     guardara valor asignable a atributo
	 * @param cuentas guardara valor asignable a atributo cuentas
	 * @return usado devolvera true o false segun el dni este siendo usado o no
	 */
	public static boolean compruebaDniUsado(String dni, CuentaCorriente[] cuentas) {
		boolean usado = false;
		int posicion = 0;

		while (posicion < cuentas.length) {

			if (cuentas[posicion].getDni().equals(dni)) {
				usado = true;
				break;

			} else {
				posicion++;
			}
		}
		return usado;
	}

	/**
	 * metodo que buscara y devolvera la posicion en la que se encuentra un dni
	 * asignado a una cuenta especifica en el array cuentas de tipo cuentaCorriente
	 * 
	 * @param dni     guardara valor asignable a atributo dni
	 * @param cuentas guardara valor asignable a atributo cuentas
	 * @return numeroCuenta devolvera posicion del array en la que se encuentra la
	 *         cuenta con el dni especificado
	 */
	public static int numeroCuenta(String dni, CuentaCorriente[] cuentas) {
		int numeroCuenta = 0;
		int posicion = 0;

		while (posicion < cuentas.length) {

			if (cuentas[posicion].getDni().equals(dni)) {
				numeroCuenta = posicion;
				break;

			} else {
				posicion++;
			}
		}
		return numeroCuenta;
	}

}
