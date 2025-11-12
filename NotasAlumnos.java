public class NotasAlumnos {
    
    public static void calcularMedia(int[][] notasAlumnos){

    double[] mediasAlumnos = new double[notasAlumnos.length];
    for (int i = 0; i < notasAlumnos.length; i++) {
        int c = 0;
        double filaMediasAlumnos = 0;
    
        for (int j = 0; j < notasAlumnos[i].length; j++) {
            filaMediasAlumnos += notasAlumnos[i][j];
            c++;
        }
        filaMediasAlumnos /= c;
        mediasAlumnos[i] = filaMediasAlumnos;
       
    
        System.out.printf("%.2f",mediasAlumnos[i]);
        if (i < notasAlumnos.length - 1) {
            System.out.print(", ");
        }
    }
    
    }

    
    
    public static void main(String[] args) {

        int[][] notasAlumnos = new int[][] {
                { 3, 4, 5 },
                { 9, 2, 3 },
                { 5, 6, 1 },
                { 8, 6, 1 },
        };

        calcularMedia(notasAlumnos);
        // Devolver media de cada fila
        // double[] mediasAlumnos = new double[]{4,3.6,4,5};
    }
}