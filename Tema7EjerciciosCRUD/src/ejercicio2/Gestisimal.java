package ejercicio2;

/**
 * clase Gestisimal que contendra getters, setters, constructores y metodos para
 * mostrar informacion de objetos tipo Gestisimal (GESTIón SIMplificada de
 * Almacén)
 * 
 * @author juanpesca19
 *
 */
public class Gestisimal {

	private String codigo;// atributo que guardara valor de codigo

	private String descripcion;// atributo que guardara valor de descripcion

	private double precioCompra;// atributo que guardara valor de precioCompra

	private double precioVenta;// atributo que guardara valor de precioVenta

	private int stock;// atributo que guardara valor de stock

	/**
	 * constructor sin parametros
	 */
	public Gestisimal() {
		super();
		// que dara valor por defecto "vacio" a codigo
		codigo = "vacio";

	}

	/**
	 * constructor con parametros
	 * 
	 * @param codigo       contendra valor a asignar a atributo codigo
	 * @param descripcion  contendra valor a asignar a atributo descripcion
	 * @param precioCompra contendra valor a asignar a atributo precioCompra
	 * @param precioVenta  contendra valor a asignar a atributo precioVenta
	 * @param stock        contendra valor a asignar a atributo stock
	 */
	public Gestisimal(String codigo, String descripcion, double precioCompra, double precioVenta, int stock) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}

	/**
	 * getter de atributo codigo
	 * 
	 * @return codigo devolvera valor actual de atributo codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * setter de atributo codigo
	 * 
	 * @param codigo contendra valor a asignar a atributo codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * getter de atributo descripcion
	 * 
	 * @return descripcion devolvera valor actual de atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * setter de atributo descripcion
	 * 
	 * @param descripcion contendra valor a asignar a atributo descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * getter de atributo precioCompra
	 * 
	 * @return precioCompra devolvera valor actual de atributo precioCompra
	 */
	public double getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * setter de atributo precioCompra
	 * 
	 * @param precioCompra contendra valor a asignar a atributo precioCompra
	 */
	public void setPrecioCompra(double precioCompra) {
		// si parametro de entrada precioCompra tiene valor mayor a 0.0
		if (precioCompra > 0.0) {
			// doy a atributo precioCompra valor de parametro precioCompra
			this.precioCompra = precioCompra;
		}
	}

	/**
	 * getter de atributo precioVenta
	 * 
	 * @return precioVenta devolvera valor actual de atributo precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * setter de atributo precioVenta
	 * 
	 * @param precioVenta contendra valor a asignar a atributo precioVenta
	 */
	public void setPrecioVenta(double precioVenta) {
		// si parametro de entrada precioCompra tiene valor mayor a 0.0
		if (precioVenta > 0.0) {
			// doy a atributo precioVenta valor de parametro precioVenta
			this.precioVenta = precioVenta;
		}
	}

	/**
	 * getter de atributo stock
	 * 
	 * @return stock devolvera valor actual de atributo stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * setter de atributo stock
	 * 
	 * @param stock contendra valor a asignar a atributo stock
	 */
	public void setStock(int stock) {
		// si parametro de entrada stock tiene valor mayor o igual a 0
		if (stock >= 0) {
			// doy a atributo stock valor de parametro stock
			this.stock = stock;
		}
	}

	/**
	 * metodo que devolvera string con valores de atributos del objeto que lo llama
	 * para imprimir mensaje por pantalla
	 */
	@Override
	public String toString() {
		return "Codigo: " + codigo + ", descripcion: " + descripcion + ", precioCompra: " + precioCompra
				+ ", precioVenta: " + precioVenta + ", stock: " + stock;
	}

	/**
	 * metodo que incrementara el valor del atributo stock en el valor especificado
	 * en parametro de entrada incremento
	 * 
	 * @param incremento contendra valor a asignar a atributo incremento
	 */
	public void incrementarStock(int incremento) {
		// sumo a atributo stock valor de parametro incremento
		stock += incremento;
	}

	/**
	 * metodo que decrementara el valor del atributo stock en el valor especificado
	 * en parametro de entrada decremento si decremento es menor o igual a atributo
	 * stock
	 * 
	 * @param decremento contendra valor a asignar a atributo decremento
	 */
	public void decrementarStock(int decremento) {
		// si decremento es menor o igual a atributo stock
		if (decremento <= stock) {
			// resto a atributo stock valor de parametro decremento
			stock -= decremento;
		}

	}

}
