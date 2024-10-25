package prestamoslibrosapares;

public class Estudiante implements Runnable {
    private final String nomEstudiante;
    private final GestorPrestamos gestor;
    private final Libro[] libros;

    public Estudiante(String nomEstudiante, Libro[] libros) {
        this.nomEstudiante = nomEstudiante;
        this.libros = libros;
        this.gestor = new GestorPrestamos(libros);
    }

    @Override
    public void run() {
        int numPrestamos = 0;

        for (int i = 0; i < 10; i++) {
            Libro[] librosTomados = new Libro[2];
            int libro1, libro2;

            do {
                libro1 = (int) (Math.random() * libros.length);
                libro2 = (int) (Math.random() * libros.length);
            } while (libro1 == libro2);

            librosTomados[0] = libros[libro1];
            librosTomados[1] = libros[libro2];

            if (gestor.prestarLibros(librosTomados[0], librosTomados[1], nomEstudiante)) {
                numPrestamos++;

                int tiempoUso = (int) (Math.random() * 3 + 1) * 1000;
                System.out.printf("%s está usando los libros %s y %s durante %d milisegundos.\n",
                    nomEstudiante, librosTomados[0].getTitulo(), librosTomados[1].getTitulo(), tiempoUso);

                try {
                    Thread.sleep(tiempoUso);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                gestor.devolverLibros(librosTomados[0], librosTomados[1]);

                int tiempoDescanso = (int) (Math.random() * 2 + 1) * 1000;
                System.out.printf("%s está descansando durante %d milisegundos.\n", nomEstudiante, tiempoDescanso);

                try {
                    Thread.sleep(tiempoDescanso);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.printf("%s ha realizado %d préstamos totales.\n", nomEstudiante, numPrestamos);
    }
}
