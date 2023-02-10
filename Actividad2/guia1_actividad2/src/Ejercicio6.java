import java.util.Scanner;

//Inicializar clase Ejercicio6
public class Ejercicio6 {

    /* Método para hallar el área de un rectángulo a partir de su base y altura*/
    static double area_rectangulo (double a, double b) {

        double area = a * b;
        return area;
    }

    /* Método para hallar la hipotenusa de un triángulo a partir de sus dos catetos
    y utilizando el teorema de Pitágoras.
     */
    static double hipotenusa (double a, double b) {

        double catetos_cuadrados = (a*a) + (b*b);
        double raiz = Math.sqrt(catetos_cuadrados);
        double hipotenusa = Math.round(raiz*100d)/100d;
        return hipotenusa;
    }

    // Método para hallar el área de un triángulo.
    static double area_triangulo (double a, double b) {

        double area = (a*b)/2;
        return area;
    }

    // Método para hallar el perímetro de un triángulo.
    static double perimetro (double a, double b, double c) {

        double perimetro = a + b + c + hipotenusa(a, b);
        return perimetro;
    }

    // Programa principal
    public static void main(String[]args) {

        Scanner entrada = new Scanner(System.in);
        double a, b, c, area_total, perimetro_terreno;

        System.out.print("Ingresar la magnitud del lado \"a\" del terreno (en metros): ");
        a = entrada.nextDouble();

        System.out.print("Ingresar la magnitud del lado \"b\" del terreno (en metros): ");
        b = entrada.nextDouble();

        System.out.print("Ingresar la magnitud del lado \"c\" del terreno (en metros): ");
        c = entrada.nextDouble();

        area_total = area_rectangulo(a, b) + area_triangulo(a, b);
        perimetro_terreno = perimetro(a, b, c);

        System.out.println("El area total del terreno es de: " + area_total + " metros cuadrados.");
        System.out.println("El perimetro total del terreno es de: " + perimetro_terreno + " metros.");

    }




}
