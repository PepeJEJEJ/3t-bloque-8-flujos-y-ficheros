import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

public class EjercicioFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sigue = true;
        String linea;

        while (sigue) {
            System.out.println("1. ESCRIBIR");
            System.out.println("2. LEER");
            System.out.println("3. SALIR");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("datos.txt", true));
                        System.out.println("Introduce texto:");
                        String dato = sc.nextLine();
                        bw.write(dato);
                        bw.newLine();
                        bw.close();
                    } catch (Exception e) {
                    }
                    break;

                case 2:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                        br.close();
                    } catch (Exception e) {
                    }
                    break;

                case 3:
                    sigue = false;
                    break;
            }
        }
        sc.close();
    }
}
