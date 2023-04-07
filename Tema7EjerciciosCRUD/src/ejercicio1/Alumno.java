package ejercicio1;

public class Alumno {

	private String nombre = "";

	private double notaMedia;

	public Alumno() {
		super();
		nombre = null;
	}

	public Alumno(String nombre, double notaMedia) {
		super();
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		if (notaMedia > 0.0) {
			this.notaMedia = notaMedia;
		}
	}

	@Override
	public String toString() {
		return "Alumno: " + nombre + ", Nota media: " + notaMedia;
	}

}
