package admincine;


public class Funcion {
	private String id;
	private String horario;
	private Pelicula pelicula;
	private Sala sala;
	
	public Funcion(String id, String horario, Pelicula pelicula, Sala sala) {
		this.id = id;
		this.horario = horario;
		this.pelicula = pelicula;
		this.sala = sala;
	}
	
	public Funcion() {
		this.id = "";
		this.horario = "";
		this.pelicula = new Pelicula();
		this.sala =  null; // Se debe asignar explícitamente más adelante
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gethorario() {
		return horario;
	}

	public void sethorario(String horario) {
		this.horario = horario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	@Override //Sobreescritura de toString para mostrar la información correcta de los objetos.
	public String toString() {
		return "Función número: " + id + ", Pelicula: " + pelicula + ", Horario: " + horario + ", Sala: " + sala;
	}
	
	
	
}
