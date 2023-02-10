import java.util.Scanner;

//Inicializar clase Ejercicio2
public class Ejercicio2 {

    /*
    Método que determina cuantos buses son requeridos dependiendo del número
    de gordos y flacos
    */
    static int funcion (int gordos, int flacos, int sillas) {

        int sillas_g = gordos*2;
        int sillas_totales= sillas_g + flacos;
        int buses = (int) Math.ceil(sillas_totales/(double) sillas);
        return buses;
    }
    // Programa principal.
    public static void main (String[]args) {
        Scanner entrada = new Scanner(System.in);
        int gordos,flacos, sillas, buses;

        System.out.print("Ingrese cuantos estudiantes gordos irán al paseo: ");
        gordos = entrada.nextInt();

        System.out.print("Ingrese cuantos estudiantes flacos irán al paseo: ");
        flacos = entrada.nextInt();

        System.out.print("Ingrese el número de sillas que tiene cada bus: ");
        sillas = entrada.nextInt();

        buses = funcion(gordos, flacos, sillas);

        System.out.println("El número de buses que se requieren para llevar a todos los estudiantes de paseo es: " + buses + " buses");

    }

}
