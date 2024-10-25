package prestamoslibrosapares;

public class GestorPrestamos {
    private final Libro[] libros;

    public GestorPrestamos(Libro[] libros) {
        this.libros = libros;
    }

    public synchronized boolean prestarLibros(Libro libro1, Libro libro2, String nomEstudiante) {
        if (libro1.tomar(nomEstudiante)) {
            if (libro2.tomar(nomEstudiante)) {
                return true;
            } else {
                libro1.devolver();
            }
        }
        return false;
    }

    public synchronized void devolverLibros(Libro libro1, Libro libro2) {
        libro1.devolver();
        libro2.devolver();
    }
}