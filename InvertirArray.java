
import java.util.Arrays;

/**
 * Actividad: invertir un array EN SU SITIO (sin crear arrays nuevos). -
 * Devuelve la MISMA referencia que recibe (ya invertida).
 */
public class InvertirArray {

    /**
     * Invierte el contenido de 'a' en su sitio (in-place) y devuelve la misma
     * referencia. Ejemplo: ["Elefante","Perro","Serpiente","Gato","Tiburón"] →
     * ["Tiburón","Gato","Serpiente","Perro","Elefante"]
     *
     */
    public static String[] invertir(String[] a) {
        return a;
    }

    // ----------------------------------------------------------------------
    public static void main(String[] args) {
        // 1) Caso del enunciado
        String[] animales = {"Elefante", "Perro", "Serpiente", "Gato", "Tiburón"};
        System.out.println("Antes : " + Arrays.toString(animales));
        invertir(animales);
        System.out.println("Después: " + Arrays.toString(animales));
        // Esperado: [Tiburón, Gato, Serpiente, Perro, Elefante]
        System.out.println();

        // 2) Longitud par
        String[] pares = {"A", "B", "C", "D"};
        System.out.println("Antes : " + Arrays.toString(pares));
        invertir(pares);
        System.out.println("Después: " + Arrays.toString(pares));
        // Esperado: [D, C, B, A]
        System.out.println();

        // 3) Longitud impar
        String[] impares = {"uno", "dos", "tres"};
        System.out.println("Antes : " + Arrays.toString(impares));
        invertir(impares);
        System.out.println("Después: " + Arrays.toString(impares));
        // Esperado: [tres, dos, uno]
        System.out.println();

        // 4) Un solo elemento (debe quedar igual)
        String[] uno = {"solo"};
        System.out.println("Antes : " + Arrays.toString(uno));
        invertir(uno);
        System.out.println("Después: " + Arrays.toString(uno));
        // Esperado: [solo]
        System.out.println();

        // 5) Vacío (debe quedar igual, sin fallos)
        String[] vacio = {};
        System.out.println("Antes : " + Arrays.toString(vacio));
        invertir(vacio);
        System.out.println("Después: " + Arrays.toString(vacio));
        // Esperado: []
    }
}
