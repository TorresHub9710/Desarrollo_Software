
import java.util.Scanner;

//Inicializar clase Ejercicio4
public class Ejercicio4 {

	/* Método que retorna un arreglo con la información correspondiente a los gastos que tiene Pedro */
	static double[] funcion (double salario) {
		
		double[] datos_gastos = new double[3];
		datos_gastos[0] = salario*0.40;
		datos_gastos[1] = salario*0.15;
		datos_gastos[2] = salario*0.45;
		
		return datos_gastos;
		
	}

	// Programa principal
	public static void main(String[]args) {
		
		Scanner entrada = new Scanner(System.in);
		double salario;
		
		System.out.print("Ingresar el sueldo de Pedro: ");
		salario = entrada.nextDouble();
		
		double[] datos_gastos = funcion(salario);
		
		System.out.println("Pedro se gastó " + datos_gastos[0] + " en Arriendo");
		System.out.println("Pedro se gastó " + datos_gastos[1] + " en Comida");
		System.out.println("A Pedro le sobraron " + datos_gastos[2] + " de su salario");
		
		
		
	}
}
