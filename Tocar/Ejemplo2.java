import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("ejemplo.txt"))) {
            String linea; 
            int total = 0;
            // Leemos línea a línea
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                // Convertimos la línea a número y lo sumamos
                total += Integer.parseInt(linea);
            }
            System.out.println("Total: " + total);
        } catch (NumberFormatException e) {
            System.out.println("Error: el archivo contiene texto que NO es un número.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
