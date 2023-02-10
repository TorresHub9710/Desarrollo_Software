import java.util.Scanner;

//Inicializar clase Ejercicio11
public class Ejercicio11 {

    // Método que retorna las decenas de un número entero.
    static int retornar_decenas (int a) {

        int decenas = a / 10;
        return decenas;
    }

    // Método que retorna las unidades de un número entero.
    static int retornar_unidades (int a) {

        int decenas = retornar_decenas(a);
        int unidades = a - decenas *10;
        return unidades;
    }

    /* Método que permite transformar las unidades de un número arábigo en
    un número romano
     */
    static String convertir_unidades (int a){

        int unidades = retornar_unidades(a);

        if (unidades == 1) {
            return "I";
        } else if (unidades == 2) {
            return "II";
        } else if (unidades == 3) {
            return "III";
        } else if (unidades == 4) {
            return "IV";
        } else if (unidades == 5) {
            return "V";
        } else if (unidades == 6) {
            return "VI";
        } else if (unidades == 7) {
            return "VII";
        } else if (unidades == 8) {
            return "VIII";
        } else if (unidades == 9) {
            return "IX";
        } else if (unidades == 0) {
            return "";
        } else {
            return "";
        }
    }

    /* Método que permite transformar las decenas de un número arábigo en
    un número romano
     */
    static String convertir_decenas (int a){

        int decenas = retornar_decenas(a);

        if (decenas == 1) {
            return "X";
        } else if (decenas == 2) {
            return "XX";
        } else if (decenas == 3) {
            return "XXX";
        } else if (decenas == 4) {
            return "XL";
        } else if (decenas == 5) {
            return "L";
        } else if (decenas == 6) {
            return "LX";
        } else if (decenas == 7) {
            return "LXX";
        } else if (decenas == 8) {
            return "LXXX";
        } else if (decenas == 9) {
            return "XC";
        } else if (decenas == 0) {
            return "";
        } else {
            return "";
        }
    }


    // Programa principal
    public static void main(String[]args){

        Scanner entrada = new Scanner(System.in);
        int a;
        String unidades, decenas;

        System.out.print("Ingresar el número a convertir: ");
        a = entrada.nextInt();

        unidades = convertir_unidades(a);
        decenas = convertir_decenas(a);

        if (a > 99|| a < 0 ) {
            System.out.println("Error: el número que ingreso no es correcto para el programa");
        } else {
            System.out.println("El número en romano del entero que ingresó es el siguiente: " + decenas + unidades);
        }
    }

}
