package Ej2.entities;

import Ej2.enums.Color;
import Ej2.enums.ElectricConsumption;

public final class Tv extends Appliance {
    private double resolution;
    private boolean tdt;


    public Tv() {
    }

    public Tv(double price, Color color, ElectricConsumption consumption, double weight, double resolution, boolean tdt) {
        super(price, color, consumption, weight);
        this.resolution = resolution;
        this.tdt = tdt;
    }


    public double getResolution() {
        return this.resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public boolean isTdt() {
        return this.tdt;
    }

    public boolean getTdt() {
        return this.tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }


}
