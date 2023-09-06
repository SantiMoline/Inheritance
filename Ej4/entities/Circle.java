package Ej4.entities;

import Ej4.interfaces.FigureCalculation;

public class Circle implements FigureCalculation {
    public double radius;


    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Radius: " + getRadius();
    }

    
}
