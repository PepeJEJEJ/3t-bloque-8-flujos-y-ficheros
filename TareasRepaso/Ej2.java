import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nombre del producto (o FIN):");
            String nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;

            System.out.println("Precio:");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.println("Stock:");
            int stock = Integer.parseInt(sc.nextLine());

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.txt", true));
                bw.write(nombre + "," + precio + "," + stock);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }
}
