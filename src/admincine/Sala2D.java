package admincine;

import java.util.ArrayList;

public class Sala2D extends Sala {
	private TipoSonido tipoSonido;

	public Sala2D(String id, int capacidad, String tipoProyeccion, int fila, int columna, TipoSonido tipoSonido) {
		super(id, capacidad, tipoProyeccion, fila, columna);
		this.tipoSonido = tipoSonido;
	}
	public Sala2D() {
		super();
		this.tipoSonido = TipoSonido.INDEFINIDO;

	}
	public TipoSonido getTipoSonido() {
		return tipoSonido;
	}
	public void setTipoSonido(TipoSonido tipoSonido) {
		this.tipoSonido = tipoSonido;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Tipo Sonido: " + tipoSonido;
	}
}
