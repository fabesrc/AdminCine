package admincine;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        AdminCine admin = new AdminCine();

        byte opcion;
        do {
            opcion = seleccionarMenu();
            switch (opcion) {
                case 1: //Crear Pelicula
                	String nombrePelicula = JOptionPane.showInputDialog("Ingrese el nombre de la película.");
                	String duracionPelicula = JOptionPane.showInputDialog("Ingrese la duración de la película en total de minutos (Ej: 120).");
                	String director = JOptionPane.showInputDialog("Ingrese el nombre del director de la película.");
                	admin.crearPelicula(nombrePelicula, duracionPelicula, director);
                    break;
                case 2: //Crear funcion.
                	System.out.println(opcion);
                    String idFuncion = JOptionPane.showInputDialog("Ingrese el identificador de la funcion.");
                    String horarioFuncion = JOptionPane.showInputDialog("Ingrese el horario de la funcion.");
                    Pelicula pelicula= admin.seleccionarPelicula();
                    Sala2D sala2D= new Sala2D("Sala 1", 150, "2D", 3, 3, TipoSonido.ESTEREO); //Para probar la creación de la funcion.
                    admin.crearFuncion(idFuncion, horarioFuncion, pelicula, sala2D);
                    break;
                    
                case 3:
                	opcion=seleccionarMenuSala();
                	switch(opcion) {
	                	case 1:
	                		String idSala= JOptionPane.showInputDialog("Ingrese el ID de la sala.");
	                		int capacidad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de la sala."));
	                		String tipoProyeccion= JOptionPane.showInputDialog("Ingrese el tipo de proyeccion.");
	                		int fila= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas."));
	                		int columnas= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas."));
	                		admin.crearSala2D(idSala, capacidad, tipoProyeccion, fila, columnas, TipoSonido.ESTEREO);
	                		break;
	                	case 2://falta sala 3d
                	}
                    break;
                case 4:
                	String idespectador= JOptionPane.showInputDialog("Ingrese el ID del espectador.");
                	String nombre= JOptionPane.showInputDialog("Ingrese el nombre del espectador.");
                	admin.crearEspectador(idespectador, nombre);;
                    break;
                case 5:
                	admin.verPeliculas();
                    break;
                case 6:
                	admin.verFunciones();
                    break;
                case 7:
                	admin.verSalas();
                	break;
                case 8:
                	admin.verEspectadores();
                	break;
                case 9:
                	Funcion funcion= admin.seleccionarFuncion();
                	System.out.println("Id funcion" + funcion);
                	Silla silla= admin.seleccionarSilla(funcion);
                	System.out.println(silla);
                	Espectador espectador= admin.buscarSeleccionarEspectador();
                	System.out.println(espectador);
                	admin.comprarTicket(funcion, silla, espectador);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    
    
    
    public static byte seleccionarMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("===== MENÚ ADMIN CINE =====\n");
        menu.append("1: Crear Película\n");
        menu.append("2: Crear Función\n");
        menu.append("3: Crear Sala\n");
        menu.append("4: Crear Espectador\n");
        menu.append("5: Ver Peliculas\n");
        menu.append("6: Ver Fucniones\n");
        menu.append("7: Ver Salas\n");
        menu.append("8: Ver espectadores\n");
        menu.append("9: Comprar Tickets\n");
        menu.append("\n0: Salir del sistema\n");
       

        String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(opcion);
        if (opcion == null || opcion.isBlank()) {
            return 0; // Si presiona Cancel o X
        }

        try {
            return Byte.parseByte(opcion.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Se asumirá salida.");
            return 0;
        }
        
    }
    
    public static byte seleccionarMenuSala() {
        byte opcionSala;
    	do {
    		StringBuilder menu = new StringBuilder();
            menu.append("===== Seleccionar tipo de Sala =====\n");
            menu.append("1: Crear sala 2D\n");
            menu.append("2: Crear sala 3D\n");
           

            String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(opcion);
            if (opcion == null || opcion.isBlank()) {
            	JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
            	return 0; // Si presiona Cancel o X
            }

            try {
                return Byte.parseByte(opcion.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Se asumirá salida.");
                return 0;
            }
    	}while(opcionSala!=0);    	
        
    }
}
