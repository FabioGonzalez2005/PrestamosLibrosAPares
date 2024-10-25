package prestamoslibrosapares;

public class PrestamosLibrosAPares {
    public static int NUMERO_LIBROS = 9;
    public static int NUMERO_ESTUDIANTES = 4;

    public static void main(String[] args) {
        Libro libros[] = new Libro[NUMERO_LIBROS];
        libros[0] = new Libro("0-7645-2641-3", "Java");
        libros[1] = new Libro("754-2345-2649-4", "Python");
        libros[2] = new Libro("23-7676-8641-3", "HTML");
        libros[3] = new Libro("67-2345-2634-3", "C++");
        libros[4] = new Libro("88-5678-9012-3", "JavaScript");
        libros[5] = new Libro("56-9876-6543-1", "CSS");
        libros[6] = new Libro("12-3456-7890-1", "Ruby");
        libros[7] = new Libro("90-8765-4321-9", "PHP");
        libros[8] = new Libro("34-0987-1234-5", "SQL");

        Thread estudiantes[] = new Thread[NUMERO_ESTUDIANTES];
        estudiantes[0] = new Thread(new Estudiante("Fernando", libros));
        estudiantes[1] = new Thread(new Estudiante("Álvaro", libros));
        estudiantes[2] = new Thread(new Estudiante("Iriem", libros)); 
        estudiantes[3] = new Thread(new Estudiante("Samuel", libros));

        for (Thread estudiante : estudiantes) {
            estudiante.start();
        }
    }
}
