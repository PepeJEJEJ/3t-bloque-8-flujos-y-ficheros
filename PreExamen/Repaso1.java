

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Repaso1 {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        try {
        boolean sigue=true;
        while (sigue==true) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int resultado = a/b;
            System.out.println(resultado);
        }
        } catch (Exception e) {
            BufferedWriter bw=new BufferedWriter(new FileWriter("errores.log"));
            bw.write(LocalDateTime.now()+e.getMessage());
            bw.newLine();
            bw.close();
        }
    }
}