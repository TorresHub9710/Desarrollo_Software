import java.util.Scanner;

// Inicializar clase Ejercicio14
public class Ejercicio14 {

    /* Método que permite determinar qué hermano es mayor entre tres. Esto se hace a
    partir de los nombres de los hermanos (que son ingresados por el usuario) así como
    sus correspondientes edades.
     */
    static Object[] hermmano_mayor (String nombre_hermano1,String nombre_hermano2,
            String nombre_hermano3, int edad_hermano1,int edad_hermano2, int edad_hermano3) {

        Object[] datos_hermano1 = new Object[2];
        Object[] datos_hermano2 = new Object[2];
        Object[] datos_hermano3 = new Object[2];
        Object[] error = new Object[1];

        datos_hermano1[0] = nombre_hermano1;
        datos_hermano1[1] = edad_hermano1;

        datos_hermano2[0] = nombre_hermano2;
        datos_hermano2[1] = edad_hermano2;

        datos_hermano3[0] = nombre_hermano3;
        datos_hermano3[1] = edad_hermano3;

        error[0] = "Los nombres o las edades que ingresó no se corresponden con las instrucciones que le fueron dadas";

        int a, b , c;

        a = (Integer) datos_hermano1[1];
        b = (Integer) datos_hermano2[1];
        c = (Integer) datos_hermano3[1];

        if (a > b && a > c) {
            return datos_hermano1;

        } else if (b > a && b > c) {
            return datos_hermano2;

        } else if (c > a && c > b) {
            return datos_hermano3;

        } else {
            return error;
        }
    }

    // Programa principal
    public static void main(String [] args) {

        Scanner entrada = new Scanner(System.in);
        String nombre_hermano1, nombre_hermano2, nombre_hermano3;
        int edad_hermano1, edad_hermano2, edad_hermano3;

        System.out.print("Ingresar el nombre del primer hermano: ");
        nombre_hermano1 = entrada.next();
        System.out.print("Ingresar la edad del primer hermano: ");
        edad_hermano1 = entrada.nextInt();

        System.out.print("Ingresar el nombre del segundo hermano: ");
        nombre_hermano2 = entrada.next();
        System.out.print("Ingresar la edad del segundo hermano: ");
        edad_hermano2 = entrada.nextInt();

        System.out.print("Ingresar el nombre del tercer hermano: ");
        nombre_hermano3 = entrada.next();
        System.out.print("Ingresar la edad del tercer hermano: ");
        edad_hermano3 = entrada.nextInt();

        Object[] datos_hermano_mayor = hermmano_mayor(nombre_hermano1, nombre_hermano2, nombre_hermano3, edad_hermano1,
                 edad_hermano2, edad_hermano3);
        System.out.println("El nombre del hermano mayor es " + datos_hermano_mayor[0] + " y tiene " +
                datos_hermano_mayor[1] + " años");
    }


}
