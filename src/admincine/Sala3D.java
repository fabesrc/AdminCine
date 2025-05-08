package admincine;

import java.util.ArrayList;

public class Sala3D extends Sala {
	private String tipoGafas;

	public Sala3D(String id, ArrayList<Silla> sillas, int capacidad, String tipoProyeccion, int fila, int columna,
			String tipoGafas) {
		super(id, sillas, capacidad, tipoProyeccion, fila, columna);
		this.tipoGafas = tipoGafas;
	}
	
	public Sala3D() {
		super();
		this.tipoGafas = "";
	}

	public String getTipoGafas() {
		return tipoGafas;
	}

	public void setTipoGafas(String tipoGafas) {
		this.tipoGafas = tipoGafas;
	}
	
	
}
