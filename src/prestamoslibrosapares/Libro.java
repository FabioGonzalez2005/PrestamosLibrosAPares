package prestamoslibrosapares;

public class Libro {
    private final String idLibro;
    private final String titulo;
    private boolean disponible;
    private String estudianteActual;

    public Libro(String idLibro, String titulo) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.disponible = true;
        this.estudianteActual = null;
    }

    public String getIdLibro() {
        return idLibro;
    }
    
    public String getTitulo() {
        return titulo;
    }

    synchronized public boolean isDisponible() {
        return disponible;
    }

    synchronized public boolean tomar(String nomEstudiante) {
        if (disponible) {
            disponible = false;
            estudianteActual = nomEstudiante;
            System.out.println("Libro " + titulo + " ha sido tomado por " + nomEstudiante + ".");
            return true;
        } else {
            System.out.println("El libro " + titulo + " ya está siendo leído por " + estudianteActual + ".");
            return false;
        }
    }

    synchronized public void devolver() {
        disponible = true;
        estudianteActual = null;
        System.out.println("Libro " + titulo + " ha sido devuelto.");
    }
}
