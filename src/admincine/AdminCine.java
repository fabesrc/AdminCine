package admincine;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class AdminCine {
	private ArrayList<Pelicula> peliculas;
	private ArrayList<Funcion> funciones;
	
	public AdminCine() {
		this.peliculas= new ArrayList<>(); // Garantizo la inicialización de las listas a través del constructor.
		this.funciones= new ArrayList<>();
	}
	
		
	//Método para agregar una película a la lista, el retorno boolean garantiza que el método se ejecutó de forma correcta pensando en pruebas.
	public boolean crearPelicula(String nombre, String duracion, String director) {
		peliculas.add(new Pelicula (nombre, duracion, director));
		return true;
	}
	
	// Muestra el listado de peliculas creadas, permite seleccionar una y retorna la pelicula seleccionada.
	public Pelicula seleccionarPelicula() {
		int confirmacion=0;
		byte aux=1;
		String peliculaSeleccionada;
		StringBuilder cartelera = new StringBuilder(); //Se utiliza un string builder para concatenar la cartelera en un solo String y mostrar en un solo JOptionPane.
		do{			
			for(Pelicula p: peliculas) {
				cartelera.append(aux + ": ").append(p).append("\n"); // Se concatena cada una de las películas.
				aux++;
			}
			
			cartelera.append("\n" + "Seleccione la película deseada (ingrese el número correspondiente)");
			
			peliculaSeleccionada=(JOptionPane.showInputDialog(null, cartelera, "Seleccione una película: ", JOptionPane.INFORMATION_MESSAGE));
			
			if(peliculaSeleccionada==null) {
				//Aqui se debe retornar al usuario hacia el menu.
				System.out.println();
			}else {
				confirmacion= JOptionPane.showInternalConfirmDialog(null,"Usted seleccionó la película: \n" + peliculas.get(Byte.parseByte(peliculaSeleccionada)-1), "Confirmación de selección de película", 0, 2); //Retorna 0 si es positivo o 1 si es negativo
				System.out.println(confirmacion);
				if(confirmacion == 1) {
					cartelera.setLength(0); //Se reinicia el StringBuilder Cartelera en caso que no haya sido la película correcta.
					aux=1; //se reinicia para seguir mostrando el orden correcto de las películas.
				}			}
		}while(confirmacion!=0);
		return peliculas.get(Byte.parseByte(peliculaSeleccionada)-1);
	}
	
	
	//Este método es necesario para buscar una película y agregarla al crear función.
	public Pelicula buscarPelicula(String pelicula) {
		for(Pelicula p: peliculas) {
			if(p.getNombrePeli().equalsIgnoreCase(pelicula)) {
				return p;
			}
		}
		JOptionPane.showMessageDialog(null, "La película no se encuentra en el listado disponible");
		return null;
	}
	
	
	//Para crear una funcion se depende de las clases sala y pelicula.
	public boolean crearFuncion(String id, String horario, Pelicula pelicula, Sala sala) {
		funciones.add(new Funcion(id, horario, pelicula, sala));		
		return true;
	}
	
	public boolean verFunciones() {
		for(Funcion f: funciones) {
			System.out.println(f);
		}
		return true;
	}
	
	public Silla modificarAsiento() {
		
		return null;
	}
	
	public Espectador registrarEspectador() {
		
		return null;
	}
	
	

}
