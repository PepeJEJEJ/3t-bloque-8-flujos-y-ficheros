import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo1{
    public static void main(String[] args) {
        try {
            // Abrimos el "ejemplo.txt" para leerlo
            BufferedReader br = new BufferedReader(new FileReader("ejemplo.txt"));
            String linea; // Aqui guardamos lo que leamos
            while ((linea= br.readLine())!=null) {// Esto lee hasta que readLine() devuelva un null (NADA)
                System.out.println(linea);
            }
            br.close(); // Cerramos el archivo (recomendado)
        } catch (IOException e) {// Si ocurre un error al abrir o leer el archivo, lo mostramos
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
