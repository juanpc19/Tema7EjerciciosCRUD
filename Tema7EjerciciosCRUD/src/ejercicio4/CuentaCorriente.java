package ejercicio4;

/**
 * Clase Cuenta corriente que contiene metodos para realizar transacciones y ver
 * los datos de cuentas bancarias
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

			// de lo contrario no se llevara a cabo la operacion
			// y se le comunicara al usuario mediante mensaje por pantalla
		} else {
			System.out.println("Su transaccion no es posible, no tiene suficiente saldo. ");
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
	}

	/**
	 * metodo que mostrara los datos de la cuenta especificada asociada con su
	 * propio objeto
	 */
	public void mostrarInformacion() {
		// print de pantalla de los atributos con los valores del objeto con el que se
		// usa el metodo
		System.out.println("La cuenta de: " + dni + " " + nombre + ", tiene " + saldo + " de saldo.");
	}

}
