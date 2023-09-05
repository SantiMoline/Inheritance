package Ej2.entities;

import Ej2.enums.Color;
import Ej2.enums.ElectricConsumption;

public abstract class Appliance {
    protected double price;
    protected Color color;
    protected ElectricConsumption consumption;
    protected double weight;

    /**
     * Empty constructor
     */
    public Appliance() {
    }

    /**
     * Full constructor.
     */
    public Appliance(double price, Color color, ElectricConsumption consumption, double weight) {
        this.price = price;
        this.color = color;
        this.consumption = consumption;
        this.weight = weight;
    }


    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ElectricConsumption getConsumption() {
        return this.consumption;
    }

    public void setConsumption(ElectricConsumption consumption) {
        this.consumption = consumption;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "{" +
            " price='" + getPrice() + "'" +
            ", color='" + getColor() + "'" +
            ", consumption='" + getConsumption() + "'" +
            ", weight='" + getWeight() + "'" +
            "}";
    }

}
