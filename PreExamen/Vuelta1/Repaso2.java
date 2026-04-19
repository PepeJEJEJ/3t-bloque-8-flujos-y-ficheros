import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Repaso2 {
    public static void main(String[] args) {
        String idioma="";
        String modo="";
        String volumen="";
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                String clave = partes[0];
                String valor = partes[1];

                if (clave.equals("idioma"))
                    idioma = valor;
                if (clave.equals("modo_oscuro"))
                    modo = valor;
                if (clave.equals("volumen"))
                    volumen = valor;
            }

            br.close();

            String idiomaFinal = "";
            if (idioma.equals("es")) {
                idiomaFinal = idioma;
            }
            
            System.out.println("El sistema está configurado en idioma " + idiomaFinal + " con un volumen de " + volumen);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
