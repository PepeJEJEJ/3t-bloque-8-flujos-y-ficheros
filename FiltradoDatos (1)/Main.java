import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sigue = true;
        String linea;

        while (sigue) {
            System.out.println("1 VER ALUMNOS");
            System.out.println("2 PONER ALUMNOS");
            System.out.println("3 VER ADULTOS");
            System.out.println("4 SALIR");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"));
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                        br.close();
                    } catch (Exception e) {
                        registrarError(e);
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Nombre Y Edad:");
                        String nombre = sc.nextLine();
                        int edad = Integer.parseInt(sc.nextLine());

                        BufferedWriter bw = new BufferedWriter(new FileWriter("alumnos.txt", true));
                        bw.newLine();
                        bw.write(nombre + ":" + edad);
                        bw.close();

                        if (edad >= 18) {
                            BufferedWriter bw2 = new BufferedWriter(new FileWriter("adultos.txt", true));
                            bw2.newLine();
                            bw2.write(nombre + ":" + edad);
                            bw2.close();
                        }

                    } catch (Exception e) {
                        registrarError(e);
                    }
                    break;

                case 3:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("adultos.txt"));
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                        br.close();
                    } catch (Exception e) {
                        registrarError(e);
                    }
                    break;

                case 4:
                    sigue = false;
                    break;
            }
        }
        sc.close();
    }

    public static void registrarError(Exception e) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("errores.log", true));
            bw.write(e.getClass().getSimpleName());
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
        }
    }
}
