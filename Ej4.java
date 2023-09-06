import java.util.Scanner;

import Ej4.entities.Circle;
import Ej4.entities.Rectangle;

public class Ej4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's create a circle.....");
        System.out.print("Radius (cm): ");
        double radius = scan.nextDouble();
        System.out.println("Now, let's generate a rectangle....");
        System.out.print("Base: ");
        double base = scan.nextDouble();
        System.out.print("Height: ");
        double height = scan.nextDouble();

        Rectangle rect = new Rectangle(base, height);
        Circle circle = new Circle(radius);


        System.out.println("\n\nCircle information: ");
        System.out.println(circle);
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        System.out.println("Area: " + circle.calculateArea());

        System.out.println("\n\nRectangle information: ");
        System.out.println(rect);
        System.out.println("Perimeter: " + rect.calculatePerimeter());
        System.out.println("Area: " + rect.calculateArea());

    }
}
/*
 * Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas geométricas, en este caso un círculo y un rectángulo.
 * Ya que este cálculo se va a repetir en las dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los dos métodos para calcular el área,
 * el perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */