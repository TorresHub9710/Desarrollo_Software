import java.util.Scanner;

// Inicializar clase Ejercicio12
public class Ejercicio12 {

    /* Método que indica qeu día será el próximo a partir del nombre de un día
    que haya ingresado el usuario.
     */
    static String dia_siguiente (String hoy) {

        if (hoy.equals("lunes")) {
            return "martes";
        } else if (hoy.equals("martes")) {
            return "miercoles";
        } else if (hoy.equals("miercoles")) {
            return "jueves";
        } else if (hoy.equals("jueves")) {
            return "viernes";
        } else if (hoy.equals("viernes")) {
            return "sabado";
        } else if (hoy.equals("sabado")) {
            return "domingo";
        } else if (hoy.equals("domingo")) {
            return "lunes";
        } else {
            return "El día no está escritamente correctamente";
        }
    }

    // Programa principal
    public static void main(String[]args) {

        Scanner entrada = new Scanner(System.in);
        String hoy, manana;

        System.out.print("Ingrese el día actual: ");
        hoy = entrada.next();

        manana = dia_siguiente(hoy);
        System.out.println("El día de mañana es: " + manana);

    }
}
