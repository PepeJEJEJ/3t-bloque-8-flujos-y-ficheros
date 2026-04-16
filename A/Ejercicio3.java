import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean continuar=true;
        while (continuar==true) {
            System.out.println("OPCIONES: 1 PON TAREA, 2 MOSTRAR, 3 seguir, 4 Salir");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.println("Pon una nueva tarea:");
                    String nueva = sc.nextLine();

                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("tareas.txt", true));
                        bw.write(nueva);
                        bw.newLine();
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("Error al escribir");
                    }
                    break;

                case 2:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("tareas.txt"));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Error al leer");
                    }
                    break;

                case 3:
                    return;
                case 4:
                    continuar=false;
                    break;
                default:
                    System.out.println("No válida");
            }
        }
    }
}
