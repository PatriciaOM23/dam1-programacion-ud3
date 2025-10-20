/**
 * La clase {@code IntroduccionArrays} sirve como ejemplo básico para introducir
 * el uso de <b>arrays unidimensionales</b> en Java.
 * <p>
 * En este ejemplo se muestra cómo:
 * <ul>
 * <li>Declarar y crear un array de tipo {@code int}.</li>
 * <li>Asignar valores a cada elemento del array.</li>
 * <li>Pasar un array como argumento a un método.</li>
 * <li>Recorrer y mostrar su contenido por pantalla.</li>
 * </ul>
 * </p>
 *
 * <p>
 * El programa imprime las temperaturas máximas registradas durante una semana.
 * </p>
 *
 * @author Iván Corrales
 * @version 12/10/2025
 */
public class IntroduccionArrays {


    public void mostrarTemperaturas(int[] temperaturas) { //declaro la variable int[] temperaturas
      String[] dias = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"}; //INDICO LOS DIAS DE LA SEMANA QUE HAY
    for (int i = 0;i < temperaturas.length;i++){ //
        System.out.println(dias[i] + "i" + temperaturasMax[i] + "º");
    
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

        // 1. Declara un array de tipo int llamado maxTemperaturas que tiene 7 elementos
        // Cada elemento se corresponde con un día de la semana: Lunes, ... Domingo
        int[] temperaturasMax = {22,23,24,24,23,21,20};
        mostrarTemperaturas();

        // 2. Los valores son: 22, 23, 24, 24 , 23, 21, 20

        // 3. Llama a la función mostrarTemperaturas
        
    }
}