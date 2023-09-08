package Extra02.entities;

public class OfficeBuilding extends Building {
    private int officesPerFloor;
    private int officeCapacity;
    private int floors;


    public OfficeBuilding(double height, double width, double depth, int officesPerFloor, int officeCapacity, int floors) {
        super(height, width, depth);
        this.officesPerFloor = officesPerFloor;
        this.officeCapacity = officeCapacity;
        this.floors = floors;
    }


    public int getOfficesPerFloor() {
        return this.officesPerFloor;
    }

    public void setNumberOfOffices(int officesPerFloor) {
        this.officesPerFloor = officesPerFloor;
    }

    public int getOfficeCapacity() {
        return this.officeCapacity;
    }

    public void setOfficeCapacity(int officeCapacity) {
        this.officeCapacity = officeCapacity;
    }

    public int getFloors() {
        return this.floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void showBuildingCapacity() {
        System.out.println("People per floor: " + peoplePerFloor());
        System.out.println("People in the entire building: " + peoplePerBuilding());
    }

    private int peoplePerFloor() {
        return this.officeCapacity * this.officesPerFloor;
    }

    private int peoplePerBuilding() {
        return peoplePerFloor() * this.getFloors();
    }

    @Override
    public double calculateArea() {
        return (this.getDepth() * this.getWidth() * this.getFloors());
    }


    @Override
    public double calculateVolume() {
        return (this.getDepth() * this.getHeight() * this.getWidth());
    }


}
