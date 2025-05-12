package admincine;

public class Silla {
	private String id;
	private int fila;
	private int columna;
	private Espectador espectador;
	private boolean esVacio;
	
	
	public Silla(String id, int fila, int columna, Espectador espectador, boolean esVacio ) {
		this.id = id;
		this.fila = fila;
		this.columna = columna;
		this.espectador = espectador;
		this.esVacio = esVacio;
	}
	
	public Silla() {
		this.id = "";
		this.fila = 0;
		this.columna = 0;
		this.espectador = new Espectador();
		this.esVacio = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Espectador getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	public boolean getEsVacio() {
		return esVacio;
	}

	public void setEsVacio(boolean esVacio) {
		this.esVacio = esVacio;
	}
	
	public String toString() {
		return "ID Sila: " + id + "Fila: " + fila + "Columna: " + columna + "Espectador: " + espectador + "¿Silla Vacía?: " + esVacio;
	}
	

}
