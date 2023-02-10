import java.util.Scanner;

//Inicializar clase Ejercicio8
public class Ejercicio8 {

    /* Método que permite saber cuantos salones y cuantos pisos se requieren en la universidad
     a partir del número de estudiantes y la capacidad de cada salón para albergarlos.
     */
    static int[] organizacion_universidad (int numero_estudiantes, int capacidad_salon, int salones_x_piso) {

        int [] salones_pisos = new int[2];
        salones_pisos[0] = numero_estudiantes / capacidad_salon;
        salones_pisos[1] = salones_pisos[0] / salones_x_piso;
        return salones_pisos;
    }

    // Programa principal
    public static void main(String[]args) {

        Scanner entrada = new Scanner(System.in);
        int numero_estudiantes, capacidad_salon, salones_x_piso;

        System.out.print("Ingrese el número de estudiantes que hay en la universidad: ");
        numero_estudiantes = entrada.nextInt();

        System.out.print("Ingrese cuantos estudiantes habrá por salón: ");
        capacidad_salon = entrada.nextInt();

        System.out.print("Ingrese cuantos salones habrá por piso: ");
        salones_x_piso = entrada.nextInt();

        int[] salones_pisos = organizacion_universidad(numero_estudiantes, capacidad_salon, salones_x_piso);

        System.out.println("El número de salones que se necesitan para organizar a los estudiantes de la universidad" +
                "es de: " + salones_pisos[0] + " salones.");
        System.out.println("Se quiere un total de: " + salones_pisos[1] + " pisos para acomodar todos los salones que" +
                " se necesitan.");
    }

}
