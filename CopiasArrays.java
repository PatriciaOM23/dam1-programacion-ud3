import java.util.Arrays;

public class CopiasArrays {

    /** Copia manual (mismo tamaño y orden). */
    static String[] copiarManual(String[] origen) {
        
        String[] b = new String[origen.length];
        for(int i = 0; i < b.length; i++ ){
            b[i] = origen[i];
        }
        return b;
    }

    /** Copia transformando: devuelve NUEVO array en MAYÚSCULAS (origen no se toca). */
    static String[] aMayusculas(String[] origen) {
        String[] c = new String[origen.length];
        for (int i = 0; i < c.length; i++){
            c[i] = origen[i].toUpperCase();

        }
        return c;
         
    }

    /** clone()->array: copia igual, mismo tamaño. */
    static String[] copiarConClone(String[] origen) {
        return origen.clone();
    }

    /** Arrays.copyOf(array, tamaño): puede cambiar tamaño (recorta o rellena con null/0/false). */
    static String[] copiarConCopyOf(String[] origen, int nuevoTam) {
        return Arrays.copyOf(origen, nuevoTam);
    }

    /** Arrays.copyOfRange(array, from, to) -> subarray (to exclusivo). */
    static String[] subarray(String[] origen, int from, int to) {
        // Comprobar que from no puede ser menor que 0 y si lo es poner 0
        if(from < 0){
            return new String[0]; //Devuelve array de String de 0 posiciones porque no puede devolver 0 ya que es int y el método es un String
        }
        
        return Arrays.copyOfRange(origen, from, to);
         

    }

    static void assertArray(String msg, String[] esperado, String[] real) {
        boolean ok = Arrays.equals(esperado, real);
        System.out.println((ok ? "OK   " : "ERROR ") + msg);
        System.out.println("  esperado: " + Arrays.toString(esperado));
        System.out.println("  real    : " + Arrays.toString(real));
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        String[] base = {"Intro","Sunrise","Neon","Chill"};

        System.out.println("Llamada: copiarManual(" + Arrays.toString(base) + ")");
        assertArray("copiarManual",
                base,
                copiarManual(base));

        System.out.println("Llamada: aMayusculas(" + Arrays.toString(base) + ")");
        assertArray("aMayusculas",
                new String[]{"INTRO","SUNRISE","NEON","CHILL"},
                aMayusculas(base));

        System.out.println("Llamada: copiarConClone(" + Arrays.toString(base) + ")");
        assertArray("copiarConClone",
                base,
                copiarConClone(base));

        System.out.println("Llamada: copiarConCopyOf(" + Arrays.toString(base) + ", " + base.length + ")");
        assertArray("copyOf mismo tamaño",
                base,
                copiarConCopyOf(base, base.length));

        System.out.println("Llamada: copiarConCopyOf(" + Arrays.toString(base) + ", " + (base.length + 1) + ")");
        assertArray("copyOf ampliar con null",
                new String[]{"Intro","Sunrise","Neon","Chill", null},
                copiarConCopyOf(base, base.length + 1));

        System.out.println("Llamada: subarray(" + Arrays.toString(base) + ", 1, 3)");
        assertArray("copyOfRange(1,3)",
                new String[]{"Sunrise","Neon"},
                subarray(base, 1, 3));
    }
}