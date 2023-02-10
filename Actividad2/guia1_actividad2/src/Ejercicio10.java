import java.util.Scanner;

// Inicializar clase Ejercicio10
public class Ejercicio10 {

    /* Método que determina que operación se va a realizar a partir de
    un String que es introducido por el usuario y que opera dos enteros.
     */
    static double operaciones (int a, int b, String operador) {
        
        if ("+".equals(operador)){
            return a + b;
        } else if ("-".equals(operador)) {
            return a - b;
        } else if ("*".equals(operador)) {
            return a * b;
        } else if ("/".equals(operador)) {
            return (double) a / b;
        } else if ("%".equals(operador)) {
            return a % b;
        } else {
            return 0000;
        }
    }

    // Programa principal.
    public static void main(String[]args){

        Scanner entrada = new Scanner(System.in);
        int a, b;
        String operador;
        double resultado;

        System.out.print("Ingrese el primer número entero que quiere operar: ");
        a = entrada.nextInt();

        System.out.print("Ingrese el segundo número entero que quiere operar: ");
        b = entrada.nextInt();

        System.out.print("Indique la operación que quiere realizar entre los dos números escogios (+, -, *, /, %): ");
        operador = entrada.next();

        resultado = operaciones(a, b, operador);

        if (resultado==0000){
            System.out.println("Escogió una operación invalida");
        } else {
            System.out.println("El resultado de su operación es: " + resultado);
        }
    }
}
