package admincine;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Sala3D extends Sala {
	private String tipoGafas;
	private ArrayList<Silla> filaVIP;

	public Sala3D(String id, int capacidad, String tipoProyeccion, int fila, int columna, String tipoGafas) {
		super(id, capacidad, tipoProyeccion, fila, columna);
		this.tipoGafas = tipoGafas;
		this.filaVIP= new ArrayList<>();
		inicializarSillas(super.getFila(), super.getColumna());
	}
	
	public Sala3D() {
		super();
		this.tipoGafas = "";
		this.filaVIP= new ArrayList<>();
		inicializarSillas(super.getFila(), super.getColumna());
	}
	
	public ArrayList<Silla> getFilaVIP() {
		return filaVIP;
	}
	public void setFilaVIP(ArrayList<Silla> filaVIP) {
		this.filaVIP = filaVIP;
	}

	public String getTipoGafas() {
		return tipoGafas;
	}

	public void setTipoGafas(String tipoGafas) {
		this.tipoGafas = tipoGafas;
	}

	@Override
	public void inicializarSillas(int fila, int columna) {
		filaVIP.clear();
	    super.sillas.clear();
	    if(fila >= 1 && columna >=1  && columna <= 20 ) {
	    	for (int i = 0; i < fila; i++) {
	    		for (int j = 0; j < columna; j++) {
    				if(i==0) {
    	    			this.filaVIP.add(new Silla("F"+i+"C"+j,i,j,null,true));	 
    				}else {
    					super.sillas.add(new Silla("F"+i+"C"+j,i,j,null,true));
    				}
    				
	    		}

	        }
	    } else {
	    	JOptionPane.showMessageDialog(null, "La sala debe de tener mínimo 5 filas y de 8 a 20 columnas. ");
	    }
	    	System.out.println("Inicializando sala 3D con fila=" + fila + " columna=" + columna);
	    	System.out.println("Sala 3D tiene " + filaVIP.size() + " sillas VIP.");
	    	System.out.println("Sala 3D tiene " + super.sillas.size() + " sillas generales.");
	    }

}

