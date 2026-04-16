import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("datos.txt");
        if (fichero.exists()) {
            System.out.println("El archivo existe.");
            System.out.println("Nombre: " + fichero.getName());
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
            System.out.println("Tamaño: " + fichero.length() + " bytes");
            System.out.println(fichero.getClass());
        } else {
            System.out.println("El archivo no existe.");
            File carpeta = new File("documentos");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
        }
    }
}