import java.util.Scanner;
public class TablaMultiplicadoraMatriz {


    public static void multiplicadoraMatriz(int n) {
        int m = n * n ;
        int[][] matriz= {{m},{m}};
        for(int i = 0; i < n; i++){
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (n < 1 || n > 10)
        System.out.print("Ingresa un número entre 1 y 10: ");
        try {
            n = sc.nextInt();
            sc.nextLine();
        } catch (Exception error) {
            System.out.println("¡Introduce un número!");

        }

        multiplicadoraMatriz(n);
    
        sc.close();
    }
}
