import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Repaso1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int a = Integer.parseInt(sc.nextLine());
                int b = Integer.parseInt(sc.nextLine());
                int R = a / b;
                System.out.println(R);
            } catch (Exception e) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("Errores.log", true));
                    bw.write(LocalDateTime.now() + " - " + e.getMessage());
                    bw.newLine();
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}