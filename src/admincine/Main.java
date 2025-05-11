package admincine;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        AdminCine admin = new AdminCine();

        // Películas pre-cargadas
        admin.crearPelicula("Pulp Fiction", "160", "Tarantino.");
        admin.crearPelicula("Interestelar", "220", "Nolan.");
        admin.crearPelicula("Titanic", "190", "Cameron");

        byte opcion;
        do {
            opcion = seleccionarMenu();
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
        menu.append("===== MENÚ ADMIN CINE =====\n");
        menu.append("1: Crear Película\n");
        menu.append("2: Crear Función\n");
        menu.append("3: Ver películas\n");
        menu.append("4: Ver funciones\n");
        menu.append("5: Comprar ticket\n");
        menu.append("\n0: Salir del sistema\n");
       

        String opcion = JOptionPane.showInputDialog(null, menu.toString(), "Seleccione una opción:", JOptionPane.INFORMATION_MESSAGE);

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
}
