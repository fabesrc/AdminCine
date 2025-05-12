package admincine;

public class Pelicula {
	private String nombre;
	private String minDuracion;
	private String director;

	public Pelicula(String nombre, String minDuracion, String director) {
		this.nombre = nombre;
		this.minDuracion = minDuracion;
		this.director = director;
	}
	
	public Pelicula() {
		this.nombre = "";
		this.minDuracion = "";
		this.director = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMinDuracion() {
		return minDuracion;
	}

	public void setMinDuracion(String minDuracion) {
		this.minDuracion = minDuracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	@Override //Sobreescritura de toString para mostrar la información correcta de los objetos.
	public String toString() {
		return "Título: " + nombre + ", Duración: " + minDuracion + " Minutos" + ", Director: " + director;
	}
	
}


