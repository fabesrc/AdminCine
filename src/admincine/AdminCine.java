package admincine;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class AdminCine {
	private ArrayList<Pelicula> peliculas;
	private ArrayList<Funcion> funciones;
	private ArrayList<Sala2D> salas2D;
	private ArrayList<Sala3D> salas3D;
	
	public AdminCine() {
		this.peliculas= new ArrayList<>(); // Garantizo la inicialización de las listas a través del constructor.
		this.funciones= new ArrayList<>();
		this.salas2D= new ArrayList<>();
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
				Main.seleccionarMenu();
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
	public boolean verPeliculas() {
		for(Pelicula p: peliculas) {
			System.out.println(p);
		}
		return true;
	}
	
	
	//Para crear una funcion se depende de las clases sala y pelicula.
	public void crearFuncion(String id, String horario, Pelicula pelicula, Sala sala) {
		Funcion funcion = new Funcion(id, horario, pelicula, sala);
		funciones.add(funcion); // Se agrega la función a la lista de funciones creadas de la clase Admin.
		sala.agregarFunciones(new Funcion(id, horario, pelicula, sala)); //Agrega la funcion a la lista de la sala asociada.
		if(funciones.getLast().getId().equals(id)){
			JOptionPane.showInternalMessageDialog(null, "La función se ha creado de forma correcta.", "Confirmación de función creada", 1);
			Main.seleccionarMenu();
		}else {
			JOptionPane.showInternalMessageDialog(null, "Ha ocurrido un error al crear la función, por favor intente de nuevo.", "Confirmación de función creada", 0);
		}
	}
	
	
	
	public void verFunciones() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Las funciones creadas son:\n");
		for(Funcion f: funciones) {
			JOptionPane.showMessageDialog(null, mensaje.append(f + "\n"));
		}
	}
	
	
	public void crearSala2d(String id, int capacidad, String tipoProyeccion, int fila, int columna, TipoSonido tipoSonido) {
		if(salas2D.isEmpty()) {		
			salas2D.add(new Sala2D(id, capacidad, tipoProyeccion, fila, columna, tipoSonido));
			if(salas2D.getLast().getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "La sala " + id + " se ha creado de forma correcta.","SALA CREADA",1);
			}
		}else {
			for(Sala2D s : salas2D) {
				if(s.getId().equals(id)){
					JOptionPane.showMessageDialog(null, "La sala " + id + " ya se encuentra creada, por favor intente crear una sala nueva.", "SALA DUPLICADA",0);
					Main.seleccionarMenu();
					break;
				}
			}
			salas2D.add(new Sala2D(id, capacidad, tipoProyeccion, fila, columna, tipoSonido));
			if(salas2D.getLast().getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "La sala " + id + " se ha creado de forma correcta.","SALA CREADA",1);
			}
		}
		Main.seleccionarMenu();
		}
	
	public void verSalas(){
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Las salas creadas son:\n");
		for(Sala s: salas2D) {
			mensaje.append(s + "\n");
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	public Silla modificarAsiento() {
		
		return null;
	}
	
	public Espectador registrarEspectador() {
		
		return null;
	}
	
	

}
