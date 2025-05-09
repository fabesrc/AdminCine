package admincine;

public class Pelicula {
	private String nombrePeli;
	private String minDuracion;
	private String director;

	public Pelicula(String nombrePeli, String minDuracion, String director) {
		this.nombrePeli = nombrePeli;
		this.minDuracion = minDuracion;
		this.director = director;
	}
	
	public Pelicula() {
		this.nombrePeli = "";
		this.minDuracion = "";
		this.director = "";
	}

	public String getNombrePeli() {
		return nombrePeli;
	}

	public void setNombrePeli(String nombrePeli) {
		this.nombrePeli = nombrePeli;
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
		return "Título: " + nombrePeli + ", duración: " + minDuracion + " minutos" + ", Director: " + director;
	}
	
}


