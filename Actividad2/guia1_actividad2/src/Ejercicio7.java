import java.util.Scanner;

//Inicializar clase Ejercicio7
public class Ejercicio7 {

    /* Método que permite determinar la distancia que hay entre dos puntos, a partir
     de las coordenadas de estos.
     */
    static double distancia_puntos (double x1, double y1, double x2, double y2) {

        double suma_parentesis = ((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1));
        double raiz = Math.sqrt(suma_parentesis);
        double distancia = Math.round(raiz*100d)/100d;
        return distancia;
    }

    // Método que permite hallar la pendiente de una recta
    static double pendiente (double x1, double y1, double x2, double y2) {

        double pendiente = (y2 - y1) / (x2 - x1);
        return pendiente;
    }

    /* Método que permite encontrar las coordenadas del punto medio que existe
     entre dos puntos
     */
    static double[] punto_medio (double x1, double y1, double x2, double y2) {

        double[] coordenadas_punto = new double[2];
        coordenadas_punto[0] = (x1 + x2)/2;
        coordenadas_punto[1] = (y1 + y2)/2;
        return coordenadas_punto;
    }

    // Programa principal
    public static void main(String[]args) {

        Scanner entrada = new Scanner(System.in);
        double x1, y1, x2, y2, distancia, pendiente;

        System.out.print("Ingrese la coordenada x (abscisa) del primer punto: ");
        x1 = entrada.nextDouble();

        System.out.print("Ingrese la coordenada y (ordenada) del primer punto: ");
        y1 = entrada.nextDouble();

        System.out.print("Ingrese la coordenada x (abscisa) del segundo punto: ");
        x2 = entrada.nextDouble();

        System.out.print("Ingrese la coordenada y (ordenada) del segundo punto: ");
        y2 = entrada.nextDouble();

        distancia = distancia_puntos(x1, y1, x2, y2);
        pendiente = pendiente(x1, y1, x2, y2);
        double[] p_medio = punto_medio(x1, y1, x2, y2);

        System.out.println("La distancia que existe entre los dos puntos tiene una magnitud de: " + distancia );
        System.out.println("La pendiente que une a los dos puntos tiene una magnitud de: " + pendiente);
        System.out.println("La coordenada x (abscisa) del punto medio es: " + p_medio[0] + ". " +
                "La coordenada y (ordenada) del punto medio es: " + p_medio[1]);

    }

}
