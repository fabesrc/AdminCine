package admincine;

public class Main {

	public static void main(String[] args) {
		AdminCine admin = new AdminCine();
		admin.crearPelicula("Pulp Fiction", "160", "Tarantino.");
		admin.crearPelicula("Interestelar", "220", "Nolan.");
		admin.crearPelicula("Titanic", "190", "Cameron");
		admin.verPeliculas();

	}

}
