package Extra01.entities;

public class Boat {
    private String plate;
    private double length;
    private int productionYear;


    public Boat(String plate, double length, int productionYear) {
        this.plate = plate;
        this.length = length;
        this.productionYear = productionYear;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getProductionYear() {
        return this.productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double calculateModule() {
        return 10 * length;
    }

    @Override
    public String toString() {
        return "-----------------------------------" + 
            "\nPlate: " + getPlate() + 
            "\nLength: " + getLength() + 
            "\nProductionYear: " + getProductionYear();
    }


}
