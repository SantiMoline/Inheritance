package Extra03.entities;

public abstract class NonHotel extends Accomodation {
    private boolean isPrivate;
    private double surfaceArea;


    public NonHotel(String name, String address, String city, String managerName, boolean isPrivate, double surfaceArea) {
        super(name, address, city, managerName);
        this.isPrivate = isPrivate;
        this.surfaceArea = surfaceArea;
    }

    public boolean isIsPrivate() {
        return this.isPrivate;
    }

    public boolean getIsPrivate() {
        return this.isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public double getSurfaceArea() {
        return this.surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\n Is Private?: " + isIsPrivate() +
            "\nSurfaceArea: " + getSurfaceArea();
    }


}
