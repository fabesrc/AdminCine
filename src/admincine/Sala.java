package admincine;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public abstract class Sala {
	private String id;
	private ArrayList<Silla> sillas;
	private int capacidad;
	private String tipoProyeccion;
	private int fila;
	private int columna;
	private ArrayList<Funcion> funciones;
	
	
	

	public void inicializarSillas() {
	    this.sillas = new ArrayList<>();
	    
	    if(fila >= 5 && 8 <= columna && columna <= 20 ) {
	    	for (int i = 0; i < fila; i++) {
	    		for (int j = 0; j < columna; j++) {
	    			String id = "F" + i + "C" + j;
	    			this.sillas.add(new Silla(id, i, j, null, false));	
	    		}

	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "La sala debe de tener mínimo 5 filas y de 8 a 20 columnas. ");   }
	    
	    
	}
	
	
	public Sala(String id, int capacidad, String tipoProyeccion, int fila, int columna, ArrayList<Funcion> funciones) {
	    this.id = id;
	    this.capacidad = capacidad;
	    this.tipoProyeccion = tipoProyeccion;
	    this.fila = fila;
	    this.columna = columna;
	    this.funciones = funciones;
	    inicializarSillas();
	}

	
	public Sala() {
		super();
		this.id = "";
		
		this.capacidad = 0;
		this.tipoProyeccion = "";
		this.fila = 0;
		this.columna = 0;
		this.funciones = new ArrayList<>();
		
	    inicializarSillas();
		
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
