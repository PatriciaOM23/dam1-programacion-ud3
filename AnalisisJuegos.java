
import java.util.Locale;
import java.util.Scanner;

public class AnalisisJuegos {

    /**
     * Representa un videojuego con nombre y jugadores activos (en miles).
     */
    static class Juego {

        private final String nombre;
        private final int jugadoresMiles;

        public Juego(String nombre, int jugadoresMiles) {
            this.nombre = nombre;
            this.jugadoresMiles = jugadoresMiles;
        }

        public String getNombre() {
            return nombre;
        }

        public int getJugadoresMiles() {
            return jugadoresMiles;
        }

        @Override
        public String toString() {
            return String.format("%s (%,dK jugadores)", nombre, jugadoresMiles);
        }
    }

    // ---------------------------------------------------------------------
    // MÉTODOS A IMPLEMENTAR
    // ---------------------------------------------------------------------
    /**
     * Cuenta cuántos juegos tienen más jugadores que el umbral dado.
     */
    public static int contarMasJugadores(Juego[] biblioteca, int umbralMiles) {
        int c = 0;
        for (Juego biblioteca1 : biblioteca) {
            if (biblioteca1.getJugadoresMiles() > umbralMiles) {
                c++;
            }
        }

        return c;
    }

    /**
     * Cuenta cuántos juegos tienen menos jugadores que el umbral dado.
     */
    public static int contarMenosJugadores(Juego[] biblioteca, int umbralMiles) {
        int c = 0;
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i].getJugadoresMiles() < umbralMiles) {
                c++;
            }
        }

        return c;

    }

    /**
     * Cuenta cuántos juegos están en el rango [minMiles, maxMiles] (INCLUSIVO).
     */
    public static int contarJugadoresEnRango(Juego[] biblioteca, int minMiles, int maxMiles) {
        int c = 0;
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i].getJugadoresMiles() >= minMiles && biblioteca[i].getJugadoresMiles() <= maxMiles) {
                c++;

            }
        }

        return c;
    }

    /**
     * Devuelve los índices de juegos cuyo número de jugadores está en [min,
     * max] (INCLUSIVO).
     */
    public static int[] indicesJugadoresEnRango(Juego[] biblioteca, int minMiles, int maxMiles) {

        if (biblioteca.length == 0) {
            return new int[0];
        }
        // TODO:
        int c = 0;
        for (int i = 0; i < biblioteca.length; i++) {

            if (biblioteca[i].getJugadoresMiles() >= minMiles && biblioteca[i].getJugadoresMiles() <= maxMiles) {

                c++;
            }
        }
        int[] indices = new int[c];

        int j = 0;
        for (int i = 0; i < biblioteca.length; i++) {

            if (biblioteca[i].getJugadoresMiles() >= minMiles && biblioteca[i].getJugadoresMiles() <= maxMiles) {

                indices[j] = i;
                j++;
            }
        }
        return indices; // porque no me devuelve nada wtf

    }

    /**
     * Devuelve índices de juegos cuyo nombre empieza por 'inicial' (ignora
     * mayúsculas).
     */
    public static int[] indicesPorInicial(Juego[] biblioteca, char inicial) {
        // TODO:
        
        if (biblioteca.length == 0){
            return new int[0];
        }
        
        int c = 0;
        for(int i = 0; i < biblioteca.length; i++){
            char buscarInicial = biblioteca[i].getNombre().charAt(0);
            buscarInicial = Character.toLowerCase(buscarInicial);
            inicial = Character.toLowerCase(inicial);
            if(inicial == buscarInicial){
                c++;
           
            }
        }
        int[] buscarIndices = new int[c];
        int j = 0;
         for(int i = 0; i < biblioteca.length; i++){
         char buscarInicial = biblioteca[i].getNombre().charAt(0);
            buscarInicial = Character.toLowerCase(buscarInicial);
            inicial = Character.toLowerCase(inicial);
            if(inicial == buscarInicial){
                buscarIndices[j] = i;
                j++;
            }
        }   
        return buscarIndices;

    }

    /**
     * Devuelve índices de juegos que EMPIEZAN por 'inicial' y están en el rango
     * [min, max] (INCLUSIVO).
     */
    public static int[] indicesPorInicialYJugadores(Juego[] biblioteca, char inicial,
            int minMiles, int maxMiles) {
            int c = 0;
            inicial = Character.toLowerCase(inicial);
            

            for(int i = 0; i < biblioteca.length; i++){
                int jugadores = biblioteca[i].getJugadoresMiles();
                char primerCaracter = biblioteca[i].getNombre().toLowerCase().charAt(0);
                if (primerCaracter == inicial && jugadores >= minMiles && jugadores <= maxMiles){
                    c++;

                }
                
            }
            int[] indicesXInicial = new int[c];
            int j = 0;
            for(int i = 0; i < biblioteca.length; i++){
                char primerCaracter = biblioteca[i].getNombre().toLowerCase().charAt(0);
                int jugadores = biblioteca[i].getJugadoresMiles();
                if (primerCaracter == inicial && jugadores >= minMiles && jugadores <= maxMiles){
                    indicesXInicial[j] = i;
                    j++;

                }
            }
            return indicesXInicial;
            
            
    }

    /**
     * Imprime por pantalla los juegos indicados por sus índices.
     */
    public static void mostrarJuegos(Juego[] biblioteca, int[] indices) {

        for (int i = 0; i < indices.length; i++){
           System.out.println(biblioteca[indices[i]]);
        }

    }

    // ---------------------------------------------------------------------
    // MAIN
    // ---------------------------------------------------------------------
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        // Biblioteca inicial (12 juegos, cifras ficticias en miles de jugadores activos)
        Juego[] biblioteca = {
            new Juego("Minecraft", 8000),
            new Juego("Fortnite", 9500),
            new Juego("Valorant", 5200),
            new Juego("League of Legends", 11000),
            new Juego("Rocket League", 2300),
            new Juego("GTA V", 7600),
            new Juego("EA Sports FC 24", 6700),
            new Juego("Counter-Strike 2", 8400),
            new Juego("Genshin Impact", 7000),
            new Juego("Apex Legends", 4800),
            new Juego("Call of Duty: Warzone", 9000),
            new Juego("Elden Ring", 1500)
        };

        // Parámetros por defecto para comprobar los métodos cuando estén implementados
        final int UMBRAL = 6000;
        final int MIN = 3000;
        final int MAX = 8000;
        final char INICIAL = 'M';
        final int MIN_COMBO = 0;
        final int MAX_COMBO = 1_000_000;

        System.out.println("=== Demo rápida con valores por defecto ===");

        int mas = contarMasJugadores(biblioteca, UMBRAL);
        int menos = contarMenosJugadores(biblioteca, UMBRAL);
        System.out.println("Juegos con jugadores > " + UMBRAL + "K: " + mas);
        System.out.println("Juegos con jugadores < " + UMBRAL + "K: " + menos);

        int enRango = contarJugadoresEnRango(biblioteca, MIN, MAX);
        System.out.println("\nJuegos con jugadores entre " + MIN + "K y " + MAX + "K (incl.): " + enRango);

        int[] idxRango = indicesJugadoresEnRango(biblioteca, MIN, MAX);
        System.out.println("Listado del rango:");
        mostrarJuegos(biblioteca, idxRango);

        
        int[] idxCombo = indicesPorInicialYJugadores(biblioteca, INICIAL, MIN_COMBO, MAX_COMBO);
        System.out.println("\nJuegos que empiezan por '" + Character.toUpperCase(INICIAL)
                + "' y tienen entre " + MIN_COMBO + "K y " + MAX_COMBO + "K jugadores:");
        mostrarJuegos(biblioteca, idxCombo);
    }
}
