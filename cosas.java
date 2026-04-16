✅ EJERCICIO 1 — Log de errores (errores.log)
Pedir dos números, dividir infinitamente, capturar excepciones y escribir fecha + error en errores.log

java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Num1:");
                int a = Integer.parseInt(sc.nextLine());
                System.out.println("Num2:");
                int b = Integer.parseInt(sc.nextLine());

                int r = a / b;
                System.out.println("Resultado: " + r);

            } catch (Exception e) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("errores.log", true));
                    bw.write(LocalDateTime.now() + " - " + e.getMessage());
                    bw.newLine();
                    bw.close();
                } catch (IOException ex) {}
            }
        }
    }
}
✅ EJERCICIO 2 — Exportar inventario (inventario.csv)
Pedir productos (nombre, precio, stock) y guardarlos en CSV

java
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
                BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.csv", true));
                bw.write(nombre + "," + precio + "," + stock);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }
}
✅ EJERCICIO 3 — Leer config.txt y mostrar configuración
El archivo config.txt contiene:

Código
idioma:es
modo_oscuro:true
volumen:80
Programa:

java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej3 {
    public static void main(String[] args) {
        String idioma = "";
        String modo = "";
        String volumen = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                String clave = partes[0];
                String valor = partes[1];

                if (clave.equals("idioma")) idioma = valor;
                if (clave.equals("modo_oscuro")) modo = valor;
                if (clave.equals("volumen")) volumen = valor;
            }

            br.close();

            String idiomaFinal = idioma.equals("es") ? "Castellano" : idioma;

            System.out.println("El sistema está configurado en idioma " 
                + idiomaFinal + " con un volumen de " + volumen);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
✅ EJERCICIO 4 — Estadísticas de notas (notas.txt)
Calcular media, máxima, mínima, aprobados y suspensos

java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej4 {
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

                if (nota > max) max = nota;
                if (nota < min) min = nota;

                if (nota >= 5) aprobados++;
                else suspensos++;
            }

            br.close();

            double media = (double) suma / total;

            System.out.println("Media: " + media);
            System.out.println("Máxima: " + max);
            System.out.println("Mínima: " + min);
            System.out.println("Aprobados: " + aprobados);
            System.out.println("Suspensos: " + suspensos);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
