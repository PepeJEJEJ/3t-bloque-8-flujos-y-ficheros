import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // 1. Pedir datos del jugador
        System.out.print("Nombre del jugador: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Posición: ");
        String posicion = sc.nextLine();

        System.out.print("Altura (en metros): ");
        double altura = sc.nextDouble();

        System.out.print("Peso (en kg): ");
        double peso = sc.nextDouble();

        System.out.print("Salario anual: ");
        double salario = sc.nextDouble();

        // 2. Crear objeto Jugador
        Jugador j = new Jugador(nombre, edad, posicion, altura, peso, salario);

        // 3. Guardar objeto serializado
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Jugador.txt"))) {
            oos.writeObject(j);
            System.out.println("JUGADOR GUARDADO CORRECTAMENTE");
            ois.close();
        } catch (Exception e) {
            throw new Exception("ERROR AL GUARDAR EL JUGADOR");
        }
        // 4. Leer objeto desde el fichero
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Jugador.txt"))) {

            Jugador jugadorLeido = (Jugador) ois.readObject();
            System.out.println("JUGADOR LEÍDO DESDE ARCHIVO:");
            System.out.println(jugadorLeido);
        ois.close();

        } catch (Exception e) {
            throw new Exception("ERROR AL LEER EL JUGADOR");
        }
        sc.close();
    }
}
