import java.util.Scanner;

// Inicializar clase Ejercicio9
public class Ejercicio9 {

    // Método que indica cuál es el mayor entre dos enteros
    static int mayor(int a, int b) {

        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Programa Principal
    public static void main (String[]args) {

        Scanner entrada = new Scanner(System.in);
        int a, b, numero_mayor;

        System.out.print("Ingresar el primer número a verificar: ");
        a = entrada.nextInt();

        System.out.print("Ingresar el segundo número a verificar: ");
        b = entrada.nextInt();

        numero_mayor = mayor(a, b);
        System.out.println("El número mayor entre los dos seleccionados es: " + numero_mayor);

    }
}
