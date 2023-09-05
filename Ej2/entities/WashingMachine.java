package Ej2.entities;

import Ej2.enums.Color;
import Ej2.enums.ElectricConsumption;

public final class  WashingMachine extends Appliance {
    private double load;


    public WashingMachine() {
    }


    public WashingMachine(double price, Color color, ElectricConsumption consumption, double weight, double load) {
        super(price, color, consumption, weight);
        this.load = load;
    }

    public double getLoad() {
        return this.load;
    }

    public void setLoad(double load) {
        this.load = load;
    }


    
}
