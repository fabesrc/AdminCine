package admincine;

public class Espectador {
	private String id;
	private String nombre;
	
	public Espectador(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Espectador() {
		super();
		this.id = "";
		this.nombre = "";
		
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
