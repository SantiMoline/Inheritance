package Extra01.entities;

public class Yacht extends Motorboat {
    private int cabins;


    public Yacht(String plate, double length, int productionYear, int engineHp, int cabins) {
        super(plate, length, productionYear, engineHp);
        this.cabins = cabins;
    }

    public int getCabins() {
        return this.cabins;
    }

    public void setCabins(int cabins) {
        this.cabins = cabins;
    }

    @Override
    public double calculateModule() {
        return super.calculateModule() + this.cabins;
    }


    @Override
    public String toString() {
        return super.toString() + 
            "\nNumber of cabins: " + getCabins();
    }


}
