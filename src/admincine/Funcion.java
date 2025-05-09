package admincine;


public class Funcion {
	private String id;
	private String horarioFuncion;
	private Pelicula pelicula;
	private Sala sala;
	
	public Funcion(String id, String horarioFuncion, Pelicula pelicula, Sala sala) {
		super();
		this.id = id;
		this.horarioFuncion = horarioFuncion;
		this.pelicula = pelicula;
		this.sala = sala;
	}
	
	public Funcion() {
		super();
		this.id = "";
		this.horarioFuncion = "";
		this.pelicula = new Pelicula();
		this.sala =  null; // Se debe asignar explícitamente más adelante
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHorarioFuncion() {
		return horarioFuncion;
	}

	public void setHorarioFuncion(String horarioFuncion) {
		this.horarioFuncion = horarioFuncion;
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
	
	
	
	
	
}
