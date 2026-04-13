import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo3{
    public static void main(String[] args) {
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("salida.txt"));//PERMITE ESCRIBIR
            bw.newLine();//SALTO LINEA
            bw.write(1);//ESCRIBE
            bw.newLine();
            bw.write(1);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
