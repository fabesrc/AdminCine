package admincine;

import java.util.ArrayList;


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
	
	// Muestra el listado de peliculas creadas.
	public boolean verPeliculas() {
		for(Pelicula p: peliculas) {
			System.out.println(p);
		}
		return true;
	}
	
	//Este método es necesario para buscar una película y agregarla al crear función.
	public Pelicula buscarPelicula(String pelicula) {
		for(Pelicula p: peliculas) {
			if(p.getNombrePeli().equalsIgnoreCase(pelicula)) {
				return p;
			}
		}
		System.out.println("La película no se encuentra en el listado disponible");// 
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
