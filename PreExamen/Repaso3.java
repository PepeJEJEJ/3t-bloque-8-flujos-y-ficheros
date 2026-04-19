import java.io.BufferedReader;
import java.io.FileReader;

public class Repaso3 {
    public static void main(String[] args) {
        int total = 0;
        int suma = 0;
        int max = -1;
        int min = 11;
        int aprobados = 0;
        int suspensos = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("notas.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                int nota = Integer.parseInt(linea);
                suma += nota;
                total++;
                if (nota > max)
                    max = nota;
                if (nota < min)
                    min = nota;
                if (nota > 5) {
                    aprobados++;
                } else {
                    suspensos++;
                }
                double media = (double) suma / total;
                System.out.println("total"+total);
                /*System.out.println(suma);
                System.out.println(max);
                System.out.println(min);
                System.out.println(aprobados);
                System.out.println(suspensos);
                System.out.println(media);*/
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}