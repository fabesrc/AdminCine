package admincine;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class AdminCine {
	private ArrayList<Pelicula> peliculas;
	private ArrayList<Funcion> funciones;
	private ArrayList<Sala2D> salas2D;
	private ArrayList<Sala3D> salas3D;
	private ArrayList<Espectador> espectadores;
	
	public AdminCine() {
		this.peliculas= new ArrayList<>(); // Garantizo la inicialización de las listas a través del constructor.
		peliculas.add(new Pelicula("Inception", "148", "Christopher Nolan"));
        peliculas.add(new Pelicula("Parasite", "132", "Bong Joon-ho"));
        peliculas.add(new Pelicula("The Dark Knight", "152", "Christopher Nolan"));
        peliculas.add(new Pelicula("Interstellar", "169", "Christopher Nolan"));
        peliculas.add(new Pelicula("Pulp Fiction", "154", "Quentin Tarantino"));
        
        this.salas2D= new ArrayList<>();
        salas2D.add(new Sala2D("A1", 100, "2D", 5, 2, TipoSonido.ESTEREO));
        salas2D.add(new Sala2D("A2", 150, "IMAX", 6, 3, TipoSonido.ESTEREO));
        salas2D.add(new Sala2D("A3", 90, "2d", 3, 3, TipoSonido.ESTEREO));
        salas2D.add(new Sala2D("A4", 150, "IMAX", 2, 2, TipoSonido.ESTEREO));
        
		this.funciones= new ArrayList<>();
		funciones.add(new Funcion("F1", "10:00", peliculas.get(0), salas2D.get(0)));
        funciones.add(new Funcion("F2", "12:30", peliculas.get(1), salas2D.get(1)));
        funciones.add(new Funcion("F3", "15:00", peliculas.get(2), salas2D.get(0)));
        funciones.add(new Funcion("F4", "17:30", peliculas.get(3), salas2D.get(1)));
        funciones.add(new Funcion("F5", "20:00", peliculas.get(4), salas2D.get(0)));
		
		this.salas3D= new ArrayList<>();
		this.espectadores= new ArrayList<>();
		espectadores.add(new Espectador("1020526854", "Juan Pérez"));
        espectadores.add(new Espectador("1023654857", "María López"));
        espectadores.add(new Espectador("1025412563", "Carlos García"));
        espectadores.add(new Espectador("1000000001", "Ana Rodríguez"));
        espectadores.add(new Espectador("1000000002", "Pedro Sánchez"));
	}
	
	/*
	 * Métodos para gestionar películas
	 * */
		
	//Crear una película y agregar a la lista.
	public void crearPelicula(String nombre, String duracion, String director) {
		if(peliculas.isEmpty()) {
			peliculas.add(new Pelicula(nombre, duracion, director));
			if(peliculas.getLast().getNombre().equals(nombre)) {
				JOptionPane.showMessageDialog(null, "La pélicula se ha registrado de forma exitosa.");
			}
		}else {
			for(Pelicula e: peliculas) {
				if(e.getNombre().equals(nombre)) {
					JOptionPane.showMessageDialog(null, "La película ya se encuentra registrada en el sistema.");
					Main.seleccionarMenu();
					return;
				}
			}
		}
		peliculas.add(new Pelicula(nombre, duracion, director));
		if(peliculas.getLast().getNombre().equals(nombre)) {
			JOptionPane.showMessageDialog(null, "La película se ha registrado de forma exitosa.");
		}
	}
	
	//Este método solo muestra la lista de péliculas registradas.			
	public void verPeliculas() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Las películas registradas en el sistema son: \n");
		for(Pelicula p: peliculas) {
			mensaje.append(p + "\n");
		}
		JOptionPane.showMessageDialog(null, mensaje);
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
	
	/*
	 * Métodos para gestionar fnciones.
	 * */
	
	
	
	//Crear una función y agregar a la lista.
	public void crearFuncion(String id, String horario, Pelicula pelicula, Sala sala) {
		if(funciones.isEmpty()) {
			funciones.add(new Funcion(id, horario, pelicula, sala));
			if(funciones.getLast().getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "La funcion se ha creado de forma exitosa.");
			}
		}else {
			for(Funcion f: funciones) {
				if(f.getId().equals(id)) {
					JOptionPane.showMessageDialog(null, "La función ya se encuentra creada en el sistema.");
					Main.seleccionarMenu();
					return;
				}
			}
		}
		funciones.add(new Funcion(id, horario, pelicula, sala));
		if(funciones.getLast().getId().equals(id)) {
			JOptionPane.showMessageDialog(null, "El espectador se ha registrado de forma exitosa.");
		}
	}
	
	
	// Este método solo muestra el listado de funciones creadas.
	public void verFunciones() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Las funciones creadas son:\n");
		for(Funcion f: funciones) {
			mensaje.append(f + "\n");
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	// Muestra el listado de funciones creadas, permite seleccionar una y retorna el iD de la funcion seleccionada.
		public Funcion seleccionarFuncion() {
			int confirmacion=0;
			byte aux=1;
			String funcionSeleccionada;
			String idFuncion;
			StringBuilder mensaje = new StringBuilder(); //Se utiliza un string builder para concatenar en un solo String y mostrar en un solo JOptionPane.
			do{			
				for(Funcion f: funciones) {
					mensaje.append(aux + ": ").append(f).append("\n"); // Se concatena cada una de las funciones.
					aux++;
				}
				
				mensaje.append("\n" + "Seleccione la función deseada (ingrese el número correspondiente)");
				
				funcionSeleccionada=(JOptionPane.showInputDialog(null, mensaje, "Seleccione una función: ", JOptionPane.INFORMATION_MESSAGE));
				
				if(funcionSeleccionada==null) {
					//Aqui se debe retornar al usuario hacia el menu.
					Main.seleccionarMenu();
				}else {
					confirmacion= JOptionPane.showInternalConfirmDialog(null,"Usted seleccionó la función: \n" + funciones.get(Byte.parseByte(funcionSeleccionada)-1), "Confirmación de selección de funcion", 0, 2); //Retorna 0 si es positivo o 1 si es negativo
					if(confirmacion == 1) {
						mensaje.setLength(0); //Se reinicia el StringBuilder en caso que no haya sido la película correcta.
						aux=1; //Se reinicia para seguir mostrando el orden correcto de las funciones.
					}			}
			}while(confirmacion!=0);
			return funciones.get(Byte.parseByte(funcionSeleccionada)-1);
		}
	
	
	/*
	 * Métodos para gestionar sala 2D.
	 * */
	
		
	// Crea la sala 2D y la agrega a la lista.
	public void crearSala2D(String id, int capacidad, String tipoProyeccion, int fila, int columna, TipoSonido tipoSonido) {
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
					return;
				}
			}
			salas2D.add(new Sala2D(id, capacidad, tipoProyeccion, fila, columna, tipoSonido));
			if(salas2D.getLast().getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "La sala " + id + " se ha creado de forma correcta.","SALA CREADA",1);
			}
		}
		Main.seleccionarMenu();
	}
	
	//Este método solo muestra el listado de salas, incluyendo 2D y 3D
	public void verSalas(){
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Las salas creadas son:\n");
		for(Sala s: salas2D) {
			mensaje.append(s + "\n");
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	// Muestra el listado de salas 2D creadas, permite seleccionar una y retorna la sala seleccionada.
	public Sala2D seleccionarSala2D() {
		int confirmacion=0;
		byte aux=1;
		String salaSeleccionada;
		StringBuilder mensaje = new StringBuilder(); //Se utiliza un string builder para concatenar en un solo String y mostrar en un solo JOptionPane.
		do{			
			for(Sala2D f: salas2D) {
				mensaje.append(aux + ": ").append(f).append("\n"); // Se concatena cada una de las funciones.
				aux++;
			}
			
			mensaje.append("\n" + "Seleccione la salas 2D deseada (ingrese el número correspondiente)");
			
			salaSeleccionada=(JOptionPane.showInputDialog(null, mensaje, "Seleccione una sala 2D: ", JOptionPane.INFORMATION_MESSAGE));
			
			if(salaSeleccionada==null) {
				//Aqui se debe retornar al usuario hacia el menu.
				Main.seleccionarMenu();
			}else {
				confirmacion= JOptionPane.showInternalConfirmDialog(null,"Usted seleccionó la sala 2D: \n" + salas2D.get(Byte.parseByte(salaSeleccionada)-1), "Confirmación de selección de sala 2D", 0, 2); //Retorna 0 si es positivo o 1 si es negativo
				if(confirmacion == 1) {
					mensaje.setLength(0); //Se reinicia el StringBuilder en caso que no haya sido la película correcta.
					aux=1; //Se reinicia para seguir mostrando el orden correcto de las funciones.
				}			}
		}while(confirmacion!=0);
		return salas2D.get(Byte.parseByte(salaSeleccionada)-1);
	}
	
	
	/*
	 * Métodos para gestionar espectadores
	 * */
	
	// Crear espectadores y agregarlos a la lista.	
	public void crearEspectador(String id, String nombre) {
		if(espectadores.isEmpty()) {
			espectadores.add(new Espectador(id, nombre));
			if(espectadores.getLast().getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "El espectador se ha registrado de forma exitosa.");
			}
		}else {
			for(Espectador e: espectadores) {
				if(e.getId().equals(id)) {
					JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado en el sistema.");
					Main.seleccionarMenu();
					return;
				}
			}
		}
		espectadores.add(new Espectador(id, nombre));
		if(espectadores.getLast().getId().equals(id)) {
			JOptionPane.showMessageDialog(null, "El espectador se ha registrado de forma exitosa.");
		}
		Main.seleccionarMenu();
	}
	
	//Este método muestra la lista de espectaores registrados en el sistema.
	public void verEspectadores() {
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Los espectadores registrados en el sistema son: ");
		for(Espectador e: espectadores) {
			mensaje.append(e + "\n");
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	//Este método busca un usuario de la lista y confirma si está o no regitrado y retorna el ID del espectador;
	public Espectador buscarSeleccionarEspectador() {
		String idEspectador=(JOptionPane.showInputDialog(null, "Ingrese el número de identificación del espectador", "Buscar un espectador: ", JOptionPane.INFORMATION_MESSAGE));
		for(Espectador e: espectadores) {
			if(e.getId().equals(idEspectador)) {
				JOptionPane.showMessageDialog(null, "El usuario solicitado es: " + e);
				return e;
			}
		}
		JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en el sistema.");
		Main.seleccionarMenu();
		return null;
	}
	
	//Retorna la silla seleccionada de una función.
	
	public Silla seleccionarSilla(Funcion funcion) {
			StringBuilder mensaje = new StringBuilder();
			String sillaSeleccionada;
			ArrayList<Silla> listaSillas;
			int confirmacion=0;
			int aux=1;
			do{			
				mensaje.append("Seleccione la la silla:\n");				
				listaSillas=funcion.getSala().getSillas();
				for(Silla s: listaSillas) {
					mensaje.append(aux + ": " + s.getId()+"\n");
					aux++;
				}
				mensaje.append("\n" + "Seleccione la silla deseada (ingrese el número correspondiente)");
				sillaSeleccionada = (JOptionPane.showInputDialog(null, mensaje, "Seleccione una silla: ", JOptionPane.INFORMATION_MESSAGE));
				System.out.println("Silla seleccionada");
				if(listaSillas==null) {
					//Aqui se debe retornar al usuario hacia el menu.
					Main.seleccionarMenu();
				}else {
					confirmacion= JOptionPane.showInternalConfirmDialog(null,"Usted seleccionó la silla: \n" + listaSillas.get(Byte.parseByte(sillaSeleccionada)-1), "Confirmación de selección de silla.", 0, 2); //Retorna 0 si es positivo o 1 si es negativo
					if(confirmacion == 1) {
						mensaje.setLength(0); //Se reinicia el StringBuilder en caso que no haya sido la película correcta.
						aux=1; //Se reinicia para seguir mostrando el orden correcto de las funciones.
					}			}
			}while(confirmacion!=0);
			return listaSillas.get(Byte.parseByte(sillaSeleccionada)-1);
	}
	
	public void comprarTicket(Funcion funcion, Silla silla, Espectador espectador) {
		int confirmacion=0;
		for(Silla s: funcion.getSala().getSillas()) {
			if(s.getId().equals(silla.getId())) {
				if(s.getEsVacio()==true) {
					s.setEspectador(espectador);
					s.setEsVacio(false);
					confirmacion= JOptionPane.showInternalConfirmDialog(null,"Usted seleccionó la función: " + funcion, "\nSilla: " + s.getId() + "\nPara el usuario: " + espectador, 0, 2); //Retorna 0 si es positivo o 1 si es negativo
					if(confirmacion == 1) {
						JOptionPane.showMessageDialog(null, "Regresará al menú principal para reinicar la compra.");
						return;
					}else {
						JOptionPane.showMessageDialog(null, "Compra realizada exitoamente.");
					}										
				}	else {
					JOptionPane.showMessageDialog(null, "La silla no se encuentra disponible. Regresará al menú principal.");
					return;
				}
			}
		}
	}
}
