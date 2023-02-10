
import java.util.Scanner;

/* Inicializar la clase Ejercicio1 */

public class Ejercicio1 {
    //Método para hallar el valor de la función
    static int funcion (int x, int y) {
        int f = x * x + 2 * x * y + y * y;
        return f;
    }

    //Programa principal
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        int x, y, f;

        System.out.print("Ingrese el valor de la variable x: ");
        x = entrada.nextInt();

        System.out.print("Ingrese el valor de la variable y: ");
        y = entrada.nextInt();

        f = funcion(x,y);

        System.out.println("El resultado es igual a: " + f);
    }
}


