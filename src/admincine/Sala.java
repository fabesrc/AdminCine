package admincine;

import java.util.ArrayList;

public abstract class Sala {
	private String id;
	private ArrayList<Silla> sillas;
	private int capacidad;
	private String tipoProyeccion;
	private int fila;
	private int columna;
	private ArrayList<Funcion> funciones;
	
	
	public Sala(String id, ArrayList<Silla> sillas, int capacidad, String tipoProyeccion, int fila, int columna, ArrayList<Funcion> funciones) {
		super();
		this.id = id;
		this.sillas = sillas;
		this.capacidad = capacidad;
		this.tipoProyeccion = tipoProyeccion;
		this.fila = fila;
		this.columna = columna;
		this.funciones = funciones;
	}
	public Sala() {
		super();
		this.id = "";
		this.sillas = new ArrayList<>();
		this.capacidad = 0;
		this.tipoProyeccion = "";
		this.fila = 0;
		this.columna = 0;
		this.funciones = new ArrayList<>();
		
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Silla> getSillas() {
		return sillas;
	}
	public void setSillas(ArrayList<Silla> sillas) {
		this.sillas = sillas;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipoProyeccion() {
		return tipoProyeccion;
	}
	public void setTipoProyeccion(String tipoProyeccion) {
		this.tipoProyeccion = tipoProyeccion;
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
	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}
	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	
	
	
	
	
	
}
