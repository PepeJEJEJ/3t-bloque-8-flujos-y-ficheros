import java.io.BufferedReader;   // Para leer texto con buffer (más eficiente)
import java.io.BufferedWriter;   // Para escribir texto con buffer
import java.io.FileReader;       // Para leer archivos de texto
import java.io.FileWriter;       // Para escribir archivos de texto
import java.io.IOException;      // Para manejar errores de entrada/salida
import java.util.Scanner;        // Para leer datos del usuario

public class Ejercicio1Comentao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);   // Scanner para leer del teclado
        String ruta = "secreto.txt";           // Nombre del archivo donde guardaremos el secreto

        System.out.println("1. Guardar/Actualizar secreto o 2. Revelar secreto");
        int opcion = sc.nextInt();             // Leemos la opción del usuario
        sc.nextLine();                         // Limpiamos salto de línea pendiente

        switch (opcion) {

            case 1:
                // Guardar o actualizar el secreto
                String secreto = sc.nextLine();   // Leemos el texto que el usuario quiere guardar

                // try-with-resources: cierra automáticamente el BufferedWriter
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

                    bw.write(secreto);            // Escribimos el secreto en el archivo
                    System.out.println("Secreto guardado correctamente.");

                } catch (IOException e) {
                    // Si ocurre un error al escribir
                    System.out.println("Error al guardar el secreto: " + e.getMessage());
                }
                break;

            case 2:
                // Leer el secreto guardado
                System.out.println("Revelando secreto...");

                // try-with-resources: cierra automáticamente el BufferedReader
                try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

                    String linea;
                    // Leemos línea por línea hasta que no haya más
                    while ((linea = br.readLine()) != null) {
                        System.out.println("Tu secreto es: " + linea);
                    }

                } catch (IOException e) {
                    // Si el archivo no existe o no se puede leer
                    System.out.println("No se pudo leer el secreto (¿quizás no existe aún?).");
                }
                break;

            default:
                // Si el usuario introduce un número distinto de 1 o 2
                System.out.println("Opción no válida.");
        }
    }
}
