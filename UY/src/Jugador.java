import java.io.Serializable;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;
    private String posicion;
    private double altura;
    private double peso;
    private double salario;

    public Jugador(String nombre, int edad, String posicion, double altura, double peso, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.altura = altura;
        this.peso = peso;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", salario=" + salario +
                '}';
    }
}
