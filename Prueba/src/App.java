import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {

        // 1. Crear persona
        Persona p = new Persona("Ea-Nasir", 40);

        // 2. Guardar objeto
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Persona.txt"))) {
            oos.writeObject(p);
            System.out.println("GUARDADO CORRECTAMENTE");
        } catch (Exception e) {
            throw new Exception("ERROR AL GUARDAR EL OBJETO");
        }

        // 3. Leer objeto
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Persona.txt"))) {

            Persona personaLeida = (Persona) ois.readObject();
            System.out.println("LEÍDO:");
            System.out.println(personaLeida);

        } catch (Exception e) {
            throw new Exception("ERROR AL LEER");
        }
    }
}
