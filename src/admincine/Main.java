package admincine;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		AdminCine admin = new AdminCine();
		admin.crearPelicula("Pulp Fiction", "160", "Tarantino.");
		admin.crearPelicula("Interestelar", "220", "Nolan.");
		admin.crearPelicula("Titanic", "190", "Cameron");
		
		//String idFuncion=JOptionPane.showInputDialog("Por favor ingrese el ID de la función.");
		//String horarioFuncion=JOptionPane.showInputDialog("Por favor ingrese el horario de la funcion.");
		//String peliculaSeleccionada=JOptionPane.showInputDialog(null, admin.verPeliculas(), "Seleccione una película", JOptionPane.INFORMATION_MESSAGE);
		
		System.out.println(admin.seleccionarPelicula());
		//admin.crearFuncion(idFuncion);
		
		//admin.verPeliculas();
		//admin.buscarPelicula("lbos");

	}

}
