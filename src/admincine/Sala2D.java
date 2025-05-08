package admincine;

import java.util.ArrayList;

public class Sala2D extends Sala {
	private TipoSonido tipoSonido;

	public Sala2D(String id, ArrayList<Silla> sillas, int capacidad, String tipoProyeccion, int fila, int columna,
			TipoSonido tipoSonido) {
		super(id, sillas, capacidad, tipoProyeccion, fila, columna);
		this.tipoSonido = tipoSonido;
	}
	public Sala2D() {
		super();
		this.tipoSonido = tipoSonido.INDEFINIDO;
	}
	public TipoSonido getTipoSonido() {
		return tipoSonido;
	}
	public void setTipoSonido(TipoSonido tipoSonido) {
		this.tipoSonido = tipoSonido;
	}
	
	
}
