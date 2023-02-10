import java.util.Scanner;

//Inicializar clase Ejercicio5
public class Ejercicio5 {

	// Método que calcula el área de un círculo.
	static double area_circulo (double radio) {
		
		double area = Math.PI*radio*radio;
		return area;
	}
	
	/* Método que calcula el área de la corona circular a partir del área del círculo pequeño y
	grande que la componen
	 */
	static double area_corona(double radio_pequeno, double radio_grande) {
		
		double area_pequena = area_circulo(radio_pequeno);
		double area_grande = area_circulo(radio_grande);
		double area_total = area_grande - area_pequena;
		double area_c = Math.round(area_total*100d)/100d;
		return area_c;
		
	}
	
	// Programa principal.
	public static void main(String[]args) {
		
		Scanner entrada = new Scanner(System.in);
		double radio_pequeno, radio_grande, area_corona;
		
		System.out.print("El radio del circulo pequeño es de (en centimetros): ");
		radio_pequeno = entrada.nextDouble();
		
		System.out.print("El radio del circulo grande es de (en centimetros): ");
		radio_grande = entrada.nextDouble();
		
		area_corona = area_corona(radio_pequeno, radio_grande);
		System.out.println("El area de la corona circular es de: " + area_corona + " centimetros cuadrados");
	}
}
