package ejercicio2;

public class Gestisimal {

	private String codigo;

	private String descripcion;

	private double precioCompra;

	private double precioVenta;

	private int stock;

	public Gestisimal() {
		super();
		codigo = "vacio";

	}

	public Gestisimal(String codigo, String descripcion, double precioCompra, double precioVenta, int stock) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		if (precioCompra > 0.0) {
			this.precioCompra = precioCompra;
		}
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		if (precioCompra > 0.0) {
			this.precioVenta = precioVenta;
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (precioCompra >= 0) {
			this.stock = stock;
		}
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", descripcion: " + descripcion + ", precioCompra: " + precioCompra
				+ ", precioVenta: " + precioVenta + ", stock: " + stock;
	}

	public void incrementarStock(int incremento) {
		stock += incremento;
	}

	public void decrementarStock(int decremento) {
		if (decremento <= stock) {
			stock -= decremento;
		}

	}

}
