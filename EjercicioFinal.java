import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;

public class EjercicioFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sigue = true;
        String linea;
        ArrayList<String> lista = new ArrayList<>();

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

                        lista.add(dato);

                    } catch (Exception e) {
                    }
                    break;

                case 2:
                    for (String s : lista) {
                        System.out.println(s);
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
