import java.util.Scanner;

// Inicializar clase Ejercicio13
public class Ejercicio13 {

    // Método que permite determinar el aumento de un salario a partir de su monto actual.
    static double [] aumento (int salario) {

        double[] datos_aumento = new double[2];
        double salario_aumento, salario_nuevo;

        if (salario <= 800000) {
            datos_aumento[0] = 10;
            salario_aumento = salario * 0.10;
            salario_nuevo = salario + salario_aumento;
            datos_aumento[1] = salario_nuevo;
            return datos_aumento;

        } else if (salario > 800000 && salario <= 1200000) {
            datos_aumento[0] = 8;
            salario_aumento = salario * 0.08;
            salario_nuevo = salario + salario_aumento;
            datos_aumento[1] = salario_nuevo;
            return datos_aumento;

        } else  {
            datos_aumento[0] = 5;
            salario_aumento = salario * 0.05;
            salario_nuevo = salario + salario_aumento;
            datos_aumento[1] = salario_nuevo;
            return datos_aumento;
        }
    }

    // Programa principal
    public static void main(String[]args) {

        Scanner entrada = new Scanner(System.in);
        int salario;

        System.out.print("Ingrese su salario actual: ");
        salario = entrada.nextInt();

        double[] aumento_salario = aumento(salario);
        System.out.println("Debido al monto de su salario actual, a usted le corresponde un aumento del: " +
                aumento_salario[0] + " por ciento.");
        System.out.println("Gracias al aumento, su salario actual es: " + aumento_salario[1]);

    }


}
