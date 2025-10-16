import java.util.Locale;
import java.util.Scanner;

public class CarritoSuma {

    /**
     * Representa un producto del catálogo.
     */
    static class Producto {
        private final String nombre;
        private final double precio;

        /**
         * Crea un producto con nombre y precio base.
         * @param nombre nombre comercial
         * @param precio precio en euros (>= 0)
         */
        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        /** @return nombre del producto */
        public String getNombre() { return nombre; }
        /** @return precio del producto */
        public double getPrecio() { return precio; }
        @Override public String toString() { return String.format("%s - %.2f €", nombre, precio); }
    }

    /**
     * Suma los precios de todos los productos del carrito.
     * @param carrito array de productos (no nulo)
     * @return suma total en euros
     */
    public static double totalCarrito(Producto[] carrito) {
        
        // TODO:
        // 1) double total = 0;
        // 2) for-each sobre carrito → acumula p.getPrecio()
        // 3) return total;
        double total = 0;
        for(Producto producto : carrito){
            total += producto.getPrecio();
        }
        
        return total;
        
    }

    public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
        // TODO (opción teclado): pedir N, crear array, leer nombre y precio por cada producto. 
        
    
        // System.out.print("Indica el nombre del producto: ");
        // String nombre = sc.nextLine();
        // System.out.print("Indica el precio del producto");
        // double precio = sc.nextDouble();
        // sc.nextLine();
        
        

        // TODO (opción fija):
       Producto[] carrito = {
             new Producto("Teclado", 24.99),
            new Producto("Ratón", 15.50),
             new Producto("Auriculares", 39.90)
     };
 
		System.out.printf("Total: %.2f$",totalCarrito(carrito));		

        // TODO: llamar a totalCarrito(carrito) y mostrar con printf "Total: %.2f €"

	//        sc.close();
    }
}