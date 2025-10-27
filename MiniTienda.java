import java.util.Arrays;
import java.util.Locale;
import javax.lang.model.util.ElementScanner14;

public class MiniTienda {

    /** NO tocar: clase simple para el catálogo. */
    static class Producto {
        private final String nombre;
        private final double precio;
        private final int stock;

        public Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getStock() {
            return stock;
        }

        @Override
        public String toString() {
            return String.format(Locale.US, "%s - %.2f€ - stock: %d", nombre, precio, stock);
        }
    }

    // ----------------------------------------------------------------------
    // 1) Mostrar catálogo
    // Qué debe hacer:
    // Imprimir cada producto en una línea usando su toString(), por ejemplo:
    // "Camiseta - 12.99€ - stock: 7"
    // Pistas:
    // - Recorre el array con un for clásico o for-each.
    // - Si el array está vacío, no imprime nada.
    public static void mostrarCatalogo(Producto[] cat) {
        for (int i = 0; i < cat.length; i++) {
            if (cat.length > 0) {
                System.out.println(cat[i].toString());
            } else {
                System.out.println("");
            }

        }

    }

    // ----------------------------------------------------------------------
    // 2) Filtrar por presupuesto
    // Qué debe hacer:
    // Devolver un NUEVO array con los productos cuyo precio <= limite,
    // manteniendo el mismo orden que en el original.
    // Pasos sugeridos (patrón en 2 pasadas):
    // 1) Recorre y cuenta cuántos cumplen (precio <= limite).
    // 2) Crea Producto[] res del tamaño contado.
    // 3) Segunda pasada: copia (referencia) de cada producto que cumpla.
    // Ejemplo con los datos del main:
    // limite=20.00 → {Camiseta, Gorra, Calcetines}.
    public static Producto[] filtrarPorPresupuesto(Producto[] cat, double limite) {
        // TODO
        int c = 0;

        for (int i = 0; i < cat.length; i++) {
            double precio = cat[i].getPrecio();
            if (precio <= limite) {
                c++;

            }

        }
        Producto[] pFiltrado = new Producto[c];
        int j = 0;

        for (int i = 0; i < cat.length; i++) {
            double precio = cat[i].getPrecio();

            if (precio <= limite) {
                pFiltrado[j] = cat[i];
                j++;
            }

        }
        return pFiltrado;

        /*
         * double precio = cat[i].getPrecio();
         * if(precio <= limite){
         * System.out.println(cat[i]);
         * }
         */

    }

    // ----------------------------------------------------------------------
    // 3) Buscar por nombre (ignora mayúsculas)
    // Qué debe hacer:
    // Devolver el índice del PRIMER producto cuyo nombre coincida con 'buscado'
    // ignorando mayúsculas/minúsculas. Si no existe, devuelve -1.
    // Detalles:
    // - Usa equalsIgnoreCase.
    // - Devuelve en cuanto lo encuentres (no sigas buscando).
    // Ejemplo con los datos del main:
    // "gorra" → índice 3.
    public static int buscarNombre(Producto[] cat, String buscado) {
        // TODO

        for (int i = 0; i < cat.length; i++) {
            if (cat[i].getNombre().equalsIgnoreCase(buscado)) {
                return i;
            }
        }
        return -1;
    }

    // ----------------------------------------------------------------------
    // 4) Contar disponibles
    // Qué debe hacer:
    // Contar cuántos productos tienen stock > 0 y devolver ese número.
    // Pistas:
    // - Recorre el array y suma 1 cuando getStock() > 0.
    // Ejemplo con los datos del main:
    // Hay 6 disponibles (todos salvo "Jeans").
    public static int contarDisponibles(Producto[] cat) {
        // TODO
        int c = 0;
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].getStock() > 0) {
                c++;

            }

        }
        return c;

    }

    // ----------------------------------------------------------------------
    // 5) Precio “habitual” del catálogo
    // Qué debe hacer:
    // Calcular una referencia de precio: suma todos los precios y divide
    // entre la cantidad de productos. Si el array está vacío, devuelve 0.0.
    // Pistas:
    // - Usa double para acumular.
    // - No redondees aquí; el formateo se puede hacer al imprimir (printf).
    // Ejemplo con los datos del main:
    // Media ≈ 200.78 / 7 = 28.68 (mostrada con %.2f).
    public static double precioHabitual(Producto[] cat) {
        // TODO
        int c = 0;
        for (int i = 0; i < cat.length; i++) {
            c++;
        }
        double precio = 0.0;
        for (int i = 0; i < cat.length; i++) {
            precio += cat[i].getPrecio();

        }
        double result = precio / c;

        return result;
    }

    // ----------------------------------------------------------------------
    // 6a) Índice del más caro
    // Qué debe hacer:
    // Devolver el índice del producto con MAYOR precio. Si hay empate,
    // devuelve el primero que aparezca. Si el array está vacío, -1.
    // Pistas:
    // - Guarda el mejor precio visto y su índice mientras recorres.
    // Ejemplo con los datos del main:
    // "Zapatillas" (59.00) → índice 4.
    public static int indiceMasCaro(Producto[] cat) {
        // TODO
        
        
        double maxPrecio = cat[0].getPrecio();
        int indiceMaxPrecio = 0;
        for(int i = 1; i < cat.length; i++){
           if(cat[i].getPrecio() > maxPrecio){
            maxPrecio =  cat[i].getPrecio(); //Se va actualizando maxPrecio y revisa cada vez si el mismo es mayor a el indice (precio) por el que va el bucle
            indiceMaxPrecio = i;
            }
        }
         return indiceMaxPrecio;
       

                

        
    }

    // ----------------------------------------------------------------------
    // 6b) Índice del más barato
    // Qué debe hacer:
    // Devolver el índice del producto con MENOR precio. Si hay empate,
    // devuelve el primero que aparezca. Si el array está vacío, -1.
    // Ejemplo con los datos del main:
    // "Calcetines" (3.50) → índice 5.
    public static int indiceMasBarato(Producto[] cat) {
        // TODO
            double minPrecio = cat[0].getPrecio();
        int indiceMinPrecio = 0;
        for(int i = 1; i < cat.length; i++){
           if(cat[i].getPrecio() < minPrecio){
            minPrecio =  cat[i].getPrecio(); //Se va actualizando maxPrecio y revisa cada vez si el mismo es mayor a el indice (precio) por el que va el bucle
            indiceMinPrecio = i;
            }
        }
         return indiceMinPrecio;
       

                

        
    }
    // ----------------------------------------------------------------------
    // 7) Aplicar descuento (%) devolviendo un NUEVO array
    // Qué debe hacer:
    // Crear y devolver un nuevo array de productos con el mismo nombre/stock,
    // pero con el precio rebajado según 'porcentaje'.
    // ¡No modifiques el array original!
    // Pasos sugeridos:
    // - Crea una copia de referencias: Producto[] res = Arrays.copyOf(cat,
    // cat.length);
    // - Recorre res y sustituye cada posición por un NUEVO Producto con:
    // precioNuevo = precio * (1 - porcentaje/100.0)
    // - Opcional (robustez): evita precios negativos con Math.max(precioNuevo, 0).
    // Ejemplo:
    // 10% de descuento → precio * 0.9
    public static Producto[] aplicarDescuento(Producto[] cat, double porcentaje) {
        // TODO
        return new Producto[0];
    }

    // ----------------------------------------------------------------------
    // 8) Sublista / página [from, to)
    // Qué debe hacer:
    // Devolver un trozo del catálogo desde 'from' (incluido) hasta 'to' (excluido).
    // Ajusta límites para que no haya errores:
    // from = Math.max(0, from)
    // to = Math.min(cat.length, to)
    // si from > to → from = to (subarray vacío)
    // Usa Arrays.copyOfRange(cat, from, to).
    // Ejemplo con los datos del main:
    // [0,3) → {Camiseta, Jeans, Sudadera}
    public static Producto[] pagina(Producto[] cat, int from, int to) {
        // TODO
        return new Producto[0];
    }

    // ----------------------------------------------------------------------

    public static void main(String[] args) {
        Producto[] datos = {
                new Producto("Camiseta", 12.99, 7),
                new Producto("Jeans", 29.90, 0),
                new Producto("Sudadera", 35.50, 5),
                new Producto("Gorra", 9.99, 12),
                new Producto("Zapatillas", 59.00, 2),
                new Producto("Calcetines", 3.50, 30),
                new Producto("Chaqueta", 49.90, 1)
        };

        // Llamadas de ejemplo (podéis comentar/descomentar para probar)
        mostrarCatalogo(datos);

        Producto[] caben = filtrarPorPresupuesto(datos, 20.00);
        System.out.println("Caben en 20€: " + Arrays.toString(caben));

        int pos = buscarNombre(datos, "gorra");
        System.out.println("Posición de 'gorra': " + pos);

        System.out.println("Disponibles: " + contarDisponibles(datos));
        System.out.printf(Locale.US, "Precio “habitual”: %.2f€%n", precioHabitual(datos));

        int iCaro = indiceMasCaro(datos);
        int iBarato = indiceMasBarato(datos);
        if (iCaro >= 0)
            System.out.println("Más caro: " + datos[iCaro]);
        if (iBarato >= 0)
            System.out.println("Más barato: " + datos[iBarato]);

        Producto[] dto10 = aplicarDescuento(datos, 10); // -10%
        System.out.println("Con descuento: " + Arrays.toString(dto10));

        Producto[] pag = pagina(datos, 0, 3);
        System.out.println("Página [0,3): " + Arrays.toString(pag));
    }
}