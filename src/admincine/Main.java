package admincine;

import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args) {
		AdminCine admin = new AdminCine();
		
		admin.crearPelicula("Pulp Fiction", "160", "Tarantino.");
		admin.crearPelicula("Interestelar", "220", "Nolan.");
		admin.crearPelicula("Titanic", "190", "Cameron");
        
		byte opcion;
        
        do {
            /*String entrada = JOptionPane.showInputDialog(null, "Ingrese la opción que desea realizar: ");
            if (entrada == null || entrada.isBlank()) return;

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor ingrese un número.");
                continue;
            }*/
        	opcion= seleccionarMenu();
            switch (opcion) {
                case 1: //Crear Pelicula
                	String nombrePelicula = JOptionPane.showInputDialog("Ingrese el nombre de la película.");
                	String duracionPelicula = JOptionPane.showInputDialog("Ingrese la duración de la película en total de minutos (Ej: 120).");
                	String director = JOptionPane.showInputDialog("Ingrese el nombre del director de la película.");
                	admin.crearPelicula(nombrePelicula, duracionPelicula, director);
                	admin.verPeliculas();
                    break;
                case 2: //Crear funcion.
                    String idFuncion = JOptionPane.showInputDialog("Ingrese el identificador de la funcion.");
                    String horarioFuncion = JOptionPane.showInputDialog("Ingrese el horario de la funcion.");
                    Pelicula pelicula= admin.seleccionarPelicula();
                    Sala2D sala2D= new Sala2D("Sala 1", 150, "2D", 8, 20, TipoSonido.ESTEREO); //Para probar la creación de la funcion.
                    admin.crearFuncion(idFuncion, horarioFuncion, pelicula, sala2D);
                    admin.verFunciones();
                    break;
                case 3:
                	admin.crearSala2d("Sala 1 2D", 150, "Proyeccion 2D", 8, 20, TipoSonido.ESTEREO);
                	/*String idSala = JOptionPane.showInputDialog("Ingrese el identificador de la sala."); 
                    int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de publico de la sala."));
                    String tipoProyeccion= JOptionPane.showInputDialog("Ingrese el tipo de proyección de la sala.");
                    int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad filas de la sala."));
                    int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas de la sala."));
                    String tipoSonido = JOptionPane.showInputDialog("Seleccione el tipo de sonido de la sala.")
                    */
                    break;
                case 4:
                	admin.verSalas();
                    break;
                case 5:
                    break;
                case 6:
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
        menu.append("1: Crear Película.\n2: Crear Función.\n3: Crear Sala. \n4: Ver salas creadas. \n0: Salir del sistema."); //Para agregar más opciones al menú se debe hacer aquí y seguir la estructura.
    	String opcion=(JOptionPane.showInputDialog(null, menu, "Seleccione una opcion: ", JOptionPane.INFORMATION_MESSAGE));
        return Byte.parseByte(opcion);
        }
    	
    	/*JOptionPane.showMessageDialog(null,
            "===== MENÚ CINE =====\n" +
            "1.  \n" +
            "2.  \n" +
            "3.  \n" +
            "4.  \n" +
            "5.  \n" +
            "6.  \n" +
            "0. Salir"
        );*/
}
