import java.io.BufferedReader;
import java.io.FileReader;

public class Repaso2 {
    public static void main(String[] args) {
        String idioma = "";
        String modo = "";
        String volumen = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            String linea;
            while ((linea=br.readLine())!=null) {
                String[] partes= linea.split(":");
                String clave=partes[0];
                String valor=partes[1];
                if (clave.equals("idioma"))idioma=valor;
                if (clave.equals("modo"))modo=valor;
                if (clave.equals("volumen"))volumen=valor;
            }
            br.close();
            String lenguaF="";
            if (idioma.equals("es")) {
                lenguaF=idioma;
            }
            System.out.println("El sistema está configurado en idioma "+lenguaF+" con un volumen de "+volumen);
        } catch (Exception e) {
        }
    }
}
