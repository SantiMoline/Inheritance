package Ej4.entities;

import Ej4.interfaces.FigureCalculation;

public class Rectangle implements FigureCalculation {
    private double base;
    private double height;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return this.base * this.height;
    }

    @Override
    public double calculatePerimeter() {
        return (this.base + this.height) * 2;
    }

    @Override
    public String toString() {
        return
            "Base: " + getBase() +
            "\nHeight: " + getHeight();
    }



}
