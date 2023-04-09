package ejercicio3;

/**
 * clase Pizza que contendra metodos aplicables al Objeto Pizza y atributos para
 * crear una lista de pedidos de pizzas
 * 
 * @author juanpesca19
 *
 */
public class Pizza {

	private int codigo;// atributo que guardara el codigo de la pizza

	/**
	 * enumerado que guardara constantes como posibles valores para variable tipo
	 * Tamaño (cada variable seria un objeto)
	 */
	enum Tamaño {
		MEDIANA, FAMILIAR
	}

	/**
	 * enumerado que guardara constantes como posibles valores para variable tipo
	 * Tipo (cada variable seria un objeto)
	 */
	enum Tipo {
		MARGARITA, CUATROQUESOS, FUNGHI
	}

	/**
	 * enumerado que guardara constantes como posibles valores para variable tipo
	 * Estado (cada variable seria un objeto)
	 */
	enum Estado {
		PEDIDA, SERVIDA
	}

	private Tamaño tamaño;// atributo tamaño de tipo Tamaño tamaño tipo de pizza

	private Tipo tipo;// atributo tipo de tipo Tipo guardara tipo de pizza

	private Estado estado;// atributo estado de tipo Estado estado tipo de pizza

	/**
	 * constructor sin parametros
	 */
	public Pizza() {
		super();
	}

	/**
	 * constructor con parametros de entrada
	 * 
	 * @param codigo guardara un valor a asignar a atributo codigo
	 * @param tamaño guardara un valor a asignar a atributo tamaño
	 * @param tipo   guardara un valor a asignar a atributo tipo
	 */
	public Pizza(int codigo, Tamaño tamaño, Tipo tipo) {
		super();
		this.codigo = codigo;
		this.tamaño = tamaño;
		this.tipo = tipo;
	}

	/**
	 * getter de atributo codigo
	 * 
	 * @return codigo devolvera valor actual de atributo codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * setter de atributo codigo
	 * 
	 * @param codigo contendra valor asignable a atributo codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * getter de atributo tamaño
	 * 
	 * @return tamaño devolvera valor actual de tamaño
	 */
	public Tamaño getTamaño() {
		return tamaño;
	}

	/**
	 * setter de atributo tamaño
	 * 
	 * @param tamaño contendra valor asignable a atributo tamaño
	 */
	public void setTamaño(Tamaño tamaño) {
		this.tamaño = tamaño;
	}

	/**
	 * getter de atributo tipo
	 * 
	 * @return tipo devolvera valor actual de atributo tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * setter de atributo tipo
	 * 
	 * @param tipo contendra valor asignable para atributo tipo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * getter de atributo estado
	 * 
	 * @return estado devolvera valor actual de atributo estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * setter de atributo estado
	 * 
	 * @param estado contendra valor asignable para atributo estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * metodo que devolvera una cadena con los valores de los atributos del objeto
	 * que lo llama
	 */
	@Override
	public String toString() {
		return "Codigo: " + codigo + ", tamaño: " + tamaño + ", tipo: " + tipo + ", estado: " + estado;
	}

	/**
	 * metodo que comprobara si el valor dado a tamaño se encuentra en el enum
	 * Tamaño devolviendo true si se encuentra y false si no
	 * 
	 * @param tamaño contendra valor que buscar en el enum Tamaño
	 * @return contiene devolvera true si lo encuentra y false si no
	 */
	public static boolean contieneTamaño(String tamaño) {
		// declaro contiene que guardara true o false y lo inicializo a false
		boolean contiene = false;

		// realizo busqueda de tamaño en enum Tamaño usando bucle for each para recorrer
		// los valores del enum Tamaño con el metodo .values guardando dicho valor en t
		for (Tamaño t : Tamaño.values()) {
			// si t es igual a tamaño (aplico valueOf para pasar valor de tamaño a tipo
			// Tamaño)
			if (t.equals(Tamaño.valueOf(tamaño))) {
				// contiene pasa a ser true
				contiene = true;
				// y hago break para evitar iteraciones innecesarias
				break;
			}
		}
		return contiene;
	}

	/**
	 * metodo que comprobara si el valor dado a tipo se encuentra en el enum Tipo
	 * devolviendo true si se encuentra y false si no
	 * 
	 * @param tipo contendra valor que buscar en el enum Tipo
	 * @return contiene devolvera true si lo encuentra y false si no
	 */
	public static boolean contieneTipo(String tipo) {
		// declaro contiene que guardara true o false y lo inicializo a false
		boolean contiene = false;

		// realizo busqueda de tipo en enum Tipo usando bucle for each para recorrer
		// los valores del enum Tipo con el metodo .values guardando dicho valor en t
		for (Tipo t : Tipo.values()) {
			// si t es igual a tipo (aplico valueOf para pasar valor de tamaño a tipo Tipo)
			if (t.equals(Tipo.valueOf(tipo))) {
				// contiene pasa a ser true
				contiene = true;
				// y hago break para evitar iteraciones innecesarias
				break;
			}
		}
		return contiene;
	}
}
