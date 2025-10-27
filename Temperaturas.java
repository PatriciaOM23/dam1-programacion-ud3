public class Temperaturas {
    

    /**
     * Muestra por consola la temperatura máxima correspondiente a cada día de la semana.
     * <p>Ejemplo de salida esperada:</p>
     * <pre>
     * Lunes: 22º
     * Martes: 25º
     * Miércoles: 24º
     * ...
     * Domingo: 18º
     * </pre>
     *
     * @param temperaturas array de enteros que contiene las temperaturas máximas
     *                     correspondientes a los días de la semana, en orden.
     *                     Debe tener exactamente 7 elementos.
     */
    public static void mostrarTemperaturas(int[] temperaturas, String[] dias) {
        for(int i = 0; i < temperaturas.length;i++){
            
            
            System.out.println(dias[i] + ": " + temperaturas[i] + "º");
        }
       
    }

    /**
     * Método principal del programa. Crea un array con las temperaturas máximas
     * de la semana y llama al método {@link #mostrarTemperaturas(int[])} para
     * mostrar los valores en consola.
     *
     * @param args argumentos de línea de comandos (no utilizados en este ejemplo).
     */
    public static void main(String[] args) {
        int[] maxTemperaturas = {22,23,24,24,23,21,20};
        String [] diasSemana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        mostrarTemperaturas(maxTemperaturas, diasSemana);
        // 1. Declara un array de tipo int llamado maxTemperaturas que tiene 7 elementos
        //    Cada elemento se corresponde con un día de la semana: Lunes, ... Domingo

        // 2. Los valores son: 22, 23, 24, 24 , 23, 21, 20

        // 3. Llama a la función mostrarTemperaturas

    }
}

