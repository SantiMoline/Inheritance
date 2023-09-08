package Extra02.entities;

import Extra02.enums.Roof;

public class SportsCenter extends Building {
    private String name;
    private Roof roof;


    public SportsCenter(double height, double width, double depth, String name, Roof roof) {
        super(height, width, depth);
        this.name = name;
        this.roof = roof;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roof getRoof() {
        return this.roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }


    @Override
    public double calculateArea() {
        return this.getDepth() * this.getWidth();
    }


    @Override
    public double calculateVolume() {
        return calculateArea() * this.getHeight();
    }

}
