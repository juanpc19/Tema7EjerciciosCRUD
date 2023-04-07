package ejercicio1;

/**
 * clase que contendra constructores, setters, getters y metodo para mostrar
 * informacion por pantalla de objetos tipo Alumno
 * 
 * @author juanpesca19
 *
 */
public class Alumno {

	private String nombre;// atributo que guardara valor de nombre

	private double notaMedia;// atributo que guardara valor de nombre

	/**
	 * constructor sin parametros de entrada
	 */
	public Alumno() {
		super();
		nombre = null;
	}

	/**
	 * constructor con parametros de entrada
	 * 
	 * @param nombre    contendra valor para atributo nombre
	 * @param notaMedia contendra valor para atributo notaMedia
	 */
	public Alumno(String nombre, double notaMedia) {
		super();
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}

	/**
	 * getter de atributo nombre
	 * 
	 * @return nombre devolvera valor actual de nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * setter de atributo nombre
	 * 
	 * @param nombre contendra valor para atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter de atributo notaMedia
	 * 
	 * @return notaMedia devolvera valor actual de notaMedia
	 */
	public double getNotaMedia() {
		return notaMedia;
	}

	/**
	 * setter de atributo notaMedia
	 * 
	 * @param notaMedia contendra valor para atributo notaMedia
	 */
	public void setNotaMedia(double notaMedia) {
		// si notaMedia tiene un valor mayor a 0.0
		if (notaMedia > 0.0) {
			// asigno valor de parametro de entrada notaMedia a atributo notaMedia
			this.notaMedia = notaMedia;
		}
	}

	/**
	 * metodo que devolvera una string para mostrar por pantalla los atributos del
	 * objeto que lo llama
	 */
	@Override
	public String toString() {
		return "Alumno: " + nombre + ", Nota media: " + notaMedia;
	}

}
