package admincine;

public class Funcion {
	private String id;
	private String horarioFuncion;
	
	public Funcion(String id, String horarioFuncion) {
		super();
		this.id = id;
		this.horarioFuncion = horarioFuncion;
	}
	
	public Funcion() {
		super();
		this.id = "";
		this.horarioFuncion = "";
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
	
	
	
	
}
