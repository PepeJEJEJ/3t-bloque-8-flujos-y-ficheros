import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "secreto.txt";
        System.out.println("1. Guardar/Actualizar secreto o 2. Revelar secreto");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:
                String secreto = sc.nextLine();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
                    bw.write(secreto);
                    System.out.println("Secreto guardado correctamente.");
                } catch (IOException e) {
                    System.out.println("Error al guardar el secreto: " + e.getMessage());
                }
                break;

            case 2:
                System.out.println("Revelando secreto...");
                try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println("Tu secreto es: " + linea);
                    }
                } catch (IOException e) {
                    System.out.println("No se pudo leer el secreto (¿quizás no existe aún?).");
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}