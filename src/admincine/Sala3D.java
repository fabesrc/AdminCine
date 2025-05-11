package admincine;

import java.util.ArrayList;

public class Sala3D extends Sala {
	private String tipoGafas;
	private int filaVIP; 

	public Sala3D(String id, int capacidad, String tipoProyeccion, int fila, int columna, int filaVIP, String tipoGafas) {
		super(id, capacidad, tipoProyeccion, fila, columna);
		this.tipoGafas = tipoGafas;
		this.filaVIP = filaVIP;
	}
	
	public Sala3D() {
		super();
		this.tipoGafas = "";
		this.filaVIP = 0;
	}

	public String getTipoGafas() {
		return tipoGafas;
	}

	public void setTipoGafas(String tipoGafas) {
		this.tipoGafas = tipoGafas;
	}

	
	
}
