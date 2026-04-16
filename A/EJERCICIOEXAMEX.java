import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EJERCICIOEXAMEX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<>();
        int opcion;
        boolean continuar = true;

        while (continuar) {
            System.out.println("1 PON TAREA, 2 MOSTRAR (ArrayList), 3 MOSTRAR (Fichero), 4 SALIR");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.println("Pon una nueva tarea:");
                    String nueva = sc.nextLine();
                    tareas.add(nueva);

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
                    for (String t : tareas) {
                        System.out.println(t);
                    }
                    break;

                case 3:
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

                case 4:
                    continuar = false;
                    break;

                default:
                    System.out.println("No válida");
            }
        }
    }
}
