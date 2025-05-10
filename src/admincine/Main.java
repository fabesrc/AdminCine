package admincine;

import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args) {
		AdminCine admin = new AdminCine();
		admin.crearPelicula("Pulp Fiction", "160", "Tarantino.");
		admin.crearPelicula("Interestelar", "220", "Nolan.");
		admin.crearPelicula("Titanic", "190", "Cameron");
        
        int opcion = 0;

        do {
            mostrarMenu();
            String entrada = JOptionPane.showInputDialog(null, "Ingrese la opción que desea realizar: ");
            if (entrada == null || entrada.isBlank()) return;

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    // admin.crearPelicula(...)
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                case 4:
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

    public static void mostrarMenu() {
        JOptionPane.showMessageDialog(null,
            "===== MENÚ CINE =====\n" +
            "1.  \n" +
            "2.  \n" +
            "3.  \n" +
            "4.  \n" +
            "5.  \n" +
            "6.  \n" +
            "0. Salir"
        );
    }
}
