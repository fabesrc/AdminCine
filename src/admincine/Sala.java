package admincine;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public abstract class Sala {
	private String id;
	protected ArrayList<Silla> sillas;
	private int capacidad;
	private String tipoProyeccion;
	private int fila;
	private int columna;
	private ArrayList<Funcion> funciones;
	
	
	public Sala(String id, int capacidad, String tipoProyeccion, int fila, int columna) {
	    this.id = id;
	    this.capacidad = capacidad;
	    this.tipoProyeccion = tipoProyeccion;
	    this.fila = fila;
	    this.columna = columna;
	    this.funciones = new ArrayList<>();
	    this.sillas = new ArrayList<>();
	}

	
	public Sala() {
		super();
		this.id = "";		
		this.capacidad = 0;
		this.tipoProyeccion = "";
		this.fila = 0;
		this.columna = 0;
		this.funciones = new ArrayList<>();
		this.sillas = new ArrayList<>();
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
		
	public void agregarFunciones(Funcion funcion) {
		funciones.add(funcion);
	}
	
	@Override
	public String toString() {
		return "Id Sala: " + id + ", Capacidad: " + capacidad + ", Tipo proyección: " + tipoProyeccion;
	}
	
	public void inicializarSillas(int fila, int columna) {
	    this.sillas = new ArrayList<>();
	    
	    if(fila >= 1 && columna >=1  && columna <= 20 ) {
	    	for (int i = 0; i < fila; i++) {
	    		for (int j = 0; j < columna; j++) {
	    			this.sillas.add(new Silla("F"+i+"C"+j,i,j,null,true));	
	    		}

	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "La sala debe de tener mínimo 5 filas y de 8 a 20 columnas. ");   
	    }	   
	    System.out.println("Inicializando sala con fila=" + fila + " columna=" + columna);
	    System.out.println("Sala tiene " + sillas.size() + " sillas");
	}
	
	
	public void verSillas() {
		for(Silla s:sillas) {
			System.out.println(s.getId());
		}
	}
	
}
