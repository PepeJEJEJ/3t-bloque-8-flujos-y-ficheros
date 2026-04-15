import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        File carpeta = new File("datos_examen");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        File config = new File(carpeta, "config.log");
        if (config.exists()) {
            System.out.println(config.getAbsolutePath());
            System.out.println(config.length());
        }

        File registro = new File(carpeta, "registro.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(registro, true))) {
            bw.write("Iniciado");
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(registro))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer");
        }

        Persona pepe = new Persona("Pepe", 25);
        File usuarioDat = new File(carpeta, "usuario.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(usuarioDat))) {
            oos.writeObject(pepe);
        } catch (IOException e) {
            System.out.println("Error al serializar");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(usuarioDat))) {
            Persona p = (Persona) ois.readObject();
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar");
        }

        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Pedro", 25));
        lista.add(new Persona("Lepe", 30));
        lista.add(new Persona("Federico", 28));

        File listaDat = new File(carpeta, "lista_personas.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listaDat))) {
            oos.writeObject(lista);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }
    }
}