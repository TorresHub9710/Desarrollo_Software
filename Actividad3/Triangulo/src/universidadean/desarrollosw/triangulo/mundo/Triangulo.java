/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento Tecnolog�as de la Informaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudio: Desarrollo de Software
 * Ejercicio: Triangulo
 * Fecha: Agosto 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.triangulo.mundo;

/**
 * Clase que representa un tri�ngulo.
 */
public class Triangulo {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del tri�ngulo.
     */
    private Punto punto1;

    /**
     * Segundo punto del tri�ngulo.
     */
    private Punto punto2;

    /**
     * Tercer punto del tri�ngulo.
     */
    private Punto punto3;

    /**
     * Color de las l�neas.
     */
    private Color colorLineas;

    /**
     * Color del relleno.
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa el tri�ngulo
     */
    public Triangulo() {
        // Inicializa los puntos

        punto1 = new Punto(200, 50);
        punto2 = new Punto(300, 200);
        punto3 = new Punto(100, 200);

        // Inicializa los colores
        colorRelleno = new Color(60, 168, 56);
        colorLineas = new Color(0, 83, 24);
    }

    /**
     * Retorna el punto 1 del tri�ngulo.
     */
    public Punto darPunto1() {
        return punto1;
    }

    /**
     * Retorna el punto 2 del tri�ngulo.
     */
    public Punto darPunto2() {
        return punto2;
    }

    /**
     * Retorna el punto 3 del tri�ngulo.
     */
    public Punto darPunto3() {
        return punto3;
    }

    /**
     * Retorna el color de las l�neas del tri�ngulo.
     */
    public Color darColorLineas() {
        return colorLineas;
    }

    /**
     * Retorna el color del relleno del tri�ngulo.
     */
    public Color darColorRelleno() {
        return colorRelleno;
    }

    /**
     * Retorna el per�metro del tri�ngulo.
     */
    public double darPerimetro() {
        //TODO: Retorna la suma de todos los lados

        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double perimetro = lado1 + lado2 + lado3;

        return perimetro;
    }

    /**
     * Retorna el �rea del tri�ngulo, calculada utilizando la formula de Her�n. <br>
     */
    public double darArea() {
        // TODO: Obtener y retornar el area del tri�ngulo
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double s = (lado1 + lado2 + lado3)/2;
        double int_raiz = s * (s-lado1) * (s-lado2) * (s-lado3);
        double area = Math.sqrt(int_raiz);


        return area;
    }

    /**
     * Calcula la altura del tri�ngulo, teniendo en cuenta como base la l�nea entre el punto 1 y 2. <br>
     * Tenga en cuenta que �rea = (Base * Altura) / 2.
     */
    public double darAltura() {
        // TODO: Obtener y retornar la altura del tri�ngulo

        double lado1 = calcularLado1();
        double area = darArea();

        double altura = (2 * area)/lado1;

        return altura;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     */
    private double calcularLado1() {

        double x1 = punto1.darX();
        double y1 = punto1.darY();
        double x2 = punto2.darX();
        double y2 = punto2.darY();

        // calcula la distancia entre puntos
        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return d;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     */
    private double calcularLado2() {

        double x1 = punto2.darX();
        double y1 = punto2.darY();
        double x2 = punto3.darX();
        double y2 = punto3.darY();

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return d;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     */
    private double calcularLado3() {
        double x1 = punto3.darX();
        double y1 = punto3.darY();
        double x2 = punto1.darX();
        double y2 = punto1.darY();

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return d;
    }

    /**
     * Calcula el �ngulo opuesto entre un v�rtice de referencia y los otros dos v�rtices de un tri�ngulo.
     */
    public double calcularAnguloOpuesto(double pX1, double pY1, double pX2, double pY2, double pX3, double pY3) {
        // �ngulo 1
        double angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1);

        // �ngulo 2
        double angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1);

        // Garantiza que la diferencias de �ngulos sea la m�s peque�a.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }

        // Calcula el �ngulo opuesto
        double anguloOpuesto = (angulo1 + angulo2) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % (2.d * Math.PI);
        return anguloOpuesto;
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     */
    public void cambiarPunto1(double pX, double pY) {
        punto1.cambiarX(pX);
        punto1.cambiarY(pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     */
    public void cambiarPunto2(double pX, double pY) {
        punto2.cambiarX(pX);
        punto2.cambiarY(pY);
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     */
    public void cambiarPunto3(double pX, double pY) {
        punto3.cambiarX(pX);
        punto3.cambiarY(pY);
    }

    /**
     * Cambia el color de relleno del tri�ngulo.
     */
    public void cambiarColorRelleno(int pRojo, int pVerde, int pAzul) {
        colorRelleno.cambiarRojo(pRojo);
        colorRelleno.cambiarVerde(pVerde);
        colorRelleno.cambiarAzul(pAzul);
    }

    /**
     * Cambia el color de la l�neas del tri�ngulo.
     */
    public void cambiarColorLineas(int pRojo, int pVerde, int pAzul) {
        // TODO: Realice el cambio de los colores
        colorLineas.cambiarRojo(pRojo);
        colorLineas.cambiarVerde(pVerde);
        colorLineas.cambiarAzul(pAzul);
    }

    /**
     * Obtener el tipo de tri�ngulo. Este puede ser:
     * - equilatero: los tres lados iguales
     * - isosceles: solo dos lados iguales
     * - escaleno: todos los lados diferentes.
     */
    public String tipo() {
        // TODO: Obtener y retornar el tipo del triangulo

        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        if (lado1 == lado2 && lado1 == lado3 && lado2==lado3) {
            return "Tri�ngulo equilatero";
        } else if (lado1 == lado2 && lado1 != lado3 && lado2 != lado3) {
            return "Triangulo isoceles";
        } else if (lado2 == lado3 && lado1 != lado2 && lado1 != lado3) {
            return "Tri�ngulo isosceles";
        } else if (lado1 == lado3 && lado2 != lado1 && lado2 !=lado3) {
            return "Tri�ngulo isosceles";
        } else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
            return "Tri�ngulo escaleno";
        } else {
            return "No se pudo determinar el tipo de tri�ngulo";
        }
    }

    /**
     * Obtener el �ngulo (en radianes) entre el lado 1 y el lado 2.
     * Use la ley del coseno para tal fin
     */
    public double angulo1() {
        // TODO: Obtener y retornar el �ngulo entre los lado 1 y lado 2
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double g = Math.acos((lado1*lado1 - lado2*lado2 - lado3*lado3)/(-2 * lado2 * lado3));
        return g;
    }

    /**
     * Obtener el �ngulo (en radianes) entre el lado 2 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo2() {
        // TODO: Obtener y retornar el �ngulo entre los lado 2 y lado 3
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double g = Math.acos((lado2*lado2 - lado1*lado1 - lado3*lado3)/(-2 * lado1 * lado3));
        return g;
    }

    /**
     * Obtener el �ngulo (en radianes) entre el lado 1 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo3() {
        // TODO: Obtener y retornar el �ngulo entre los lado 1 y lado 3
        double lado1 = calcularLado1();
        double lado2 = calcularLado2();
        double lado3 = calcularLado3();

        double g = Math.acos((lado3*lado3 - lado1*lado1 - lado3*lado3)/(-2 * lado1 * lado2));

        return g;
    }

}
