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
                case 1: // Crear Película
                    String nombrePelicula = JOptionPane.showInputDialog("Ingrese el nombre de la película.");
                    String duracionPelicula = JOptionPane.showInputDialog("Ingrese la duración de la película (en minutos).");
                    String director = JOptionPane.showInputDialog("Ingrese el nombre del director.");
                    admin.crearPelicula(nombrePelicula, duracionPelicula, director);
                    admin.verPeliculas();
                    break;

                case 2: // Crear Función
                    String idFuncion = JOptionPane.showInputDialog("Ingrese el identificador de la función.");
                    String horarioFuncion = JOptionPane.showInputDialog("Ingrese el horario de la función.");
                    Pelicula pelicula = admin.seleccionarPelicula(); // Debe devolver un objeto Pelicula válido
                    Sala2D sala2D = new Sala2D(); // Provisional
                    admin.crearFuncion(idFuncion, horarioFuncion, pelicula, sala2D);
                    admin.verFunciones();
                    break;
                    
                case 3:
                	admin.verPeliculas();
                	break;
                
                case 4:
                	admin.verFunciones();
                	break;
                	
                case 5: 
//                	admin.comprarTicket();
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
