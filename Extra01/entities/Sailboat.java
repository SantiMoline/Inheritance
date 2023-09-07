package Extra01.entities;

public class Sailboat extends Boat {
    private int mast;

    public Sailboat(String plate, double length, int productionYear, int mast) {
        super(plate, length, productionYear);
        this.mast = mast;
    }

    public int getMast() {
        return this.mast;
    }

    public void setMast(int mast) {
        this.mast = mast;
    }

    @Override
    public double calculateModule() {
        return super.calculateModule() + this.mast;
    } 


    @Override
    public String toString() {
        return super.toString() + 
            "\n Number of mast: " + getMast();
    }


    
}
