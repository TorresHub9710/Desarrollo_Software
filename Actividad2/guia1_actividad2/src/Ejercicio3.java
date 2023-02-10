
import java.util.Scanner;

//Iniciar clase Ejercicio3
public class Ejercicio3 {

	/* Método que determina la altura de la escalera a partir del ángulo de inclinación
	y la altura.
	 */
	static double funcion (double x, double a) {
		
		double radianes = Math.toRadians(a);
		double seno_angulo = Math.sin(radianes);
		double longitud = x/seno_angulo;
		double y = Math.round(longitud*100.0)/100.0;
		return y;
	}
	
	//Programa Principal
	public static void main (String[]args) {
		
		Scanner entrada = new Scanner(System.in);
		double x, a, y;
		
		System.out.print("Ingrese la altura que alcanza la escalera inclinada (en metros): ");
		x = entrada.nextDouble();
		
		System.out.print("Ingrese la magnitud del angulo al que se encuentra inclinada la escalera (en grados): ");
		a = entrada.nextDouble();
		
		y = funcion(x, a);
		System.out.println("La longitud de la escalera es de " + y + " metros");
	}
	
}
