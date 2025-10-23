import java.util.Scanner;

public class Cuenta {

    public static void Devolver(int cantidad) {

        if (cantidad >= 0) {
            System.out.println(cantidad);
            cantidad--;
            Devolver(cantidad);

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int cantidad = sc.nextInt();
        Devolver(cantidad);

        sc.close();
    }
}
