import java.util.Arrays;

/** NO MODIFICAR: modelo simple de contacto */
class Contacto {
    private final String nombre;
    private final String email;
    private final String telefono; // puede venir con espacios
    private final boolean favorito;

    public Contacto(String n, String e, String t, boolean f){
        nombre=n; email=e; telefono=t; favorito=f;
    }
    public String getNombre(){ return nombre; }
    public String getEmail(){ return email; }
    public String getTelefono(){ return telefono; }
    public boolean isFavorito(){ return favorito; }

    @Override public String toString(){
        return nombre+" <"+email+"> "+telefono+(favorito?" ★":"");
    }
}

public class Agenda {

    /**
     * Devuelve el índice del PRIMER contacto cuyo nombre EMPIEZA por el prefijo dado.
     * Ignora mayúsculas/minúsculas. Si no existe, -1.
     */
    public static int buscarNombreParcial(Contacto[] a, String prefijo) {
        prefijo = prefijo.toLowerCase();

        // TODO
        for (int i = 0; i < a.length; i++) {
            if(a[i].getNombre().toLowerCase().startsWith(prefijo)){
                return i;

            }
            
        }
        return -1;
    }

    /**
     * Devuelve un NUEVO array con los contactos marcados como favoritos (favorito==true).
     * Mantén el orden de aparición.
     */

     //SI PIDEN UN NUEVO ARRAY HAY QUE PRIMERO SABER CUANTA LONGITUD TIENE (CON LAS CONDICIONES QUE TIENE PARA SABER CUANTOS DATOS ESPERAMOS)
    public static Contacto[] soloFavoritos(Contacto[] a) {
        int c = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i].isFavorito() == true){
                c++;
        }
        }
        Contacto[] favs = new Contacto[c];

        // LUEGO COMENZAMOS OTRA CUENTA PARA NO METER 2 DATOS EN EL MISMO INDICE
        int j = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i].isFavorito() == true){
                favs[j] =  a[i]; //LE DECIMOS QUE LA INFO DEL INDICE POR EL QUE VAYA j SEA LA MISMA QUE LA INFO POR EL INDICE QUE VAYA i
                j++;
                
            }
            
        }
        return favs;
        // TODO
    }

    /**
     * Devuelve un NUEVO array de contactos donde el teléfono de cada uno está “limpio” (sin espacios).
     * No modifiques los objetos originales: crea Contacto nuevo por cada posición.
     */
    public static Contacto[] telefonosNormalizados(Contacto[] a) {
        
        Contacto[] tlf = new Contacto[a.length];
        for(int i = 0; i < a.length; i++){
            String nombre = a[i].getNombre();
            String email = a[i].getEmail();
            String telefono = a[i].getTelefono();
            boolean favorito = a[i].isFavorito();
            telefono = telefono.replace(" ", "");
            
            tlf[i] = new Contacto(nombre, email, telefono, favorito);
        }

        // TODO
        return tlf;
    }

    /**
     * Devuelve un subarray [from, to) de contactos (to excluido).
     * Ajusta límites a 0..length y, si from>to, iguala from=to para evitar errores.
     */
    public static Contacto[] pagina(Contacto[] a, int from, int to) {
        Math.max(0,from);
        Math.min(to, a.length);
        if (from > to){
            from = to;
        }

        return Arrays.copyOfRange(a, from, to);
  
    }

    public static void main(String[] args) {
        Contacto[] ag = {
                new Contacto("Alba","a@x.com","600 111 222", true),
                new Contacto("miguel","m@x.com","  699 333", false),
                new Contacto("Bea","b@x.com","612444555", true)
        };
        // Pruebas si lo deseas:
        System.out.println("Empieza por 'mi': " + buscarNombreParcial(ag, "mi"));
        System.out.println("Favoritos: " + Arrays.toString(soloFavoritos(ag)));
        System.out.println("Tel. normalizados: " + Arrays.toString(telefonosNormalizados(ag)));
        System.out.println("Página [0,2): " + Arrays.toString(pagina(ag, 0, 2)));
    }
}