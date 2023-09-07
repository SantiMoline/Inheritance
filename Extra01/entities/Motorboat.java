package Extra01.entities;

public class Motorboat extends Boat {
    private int engineHp;


    public Motorboat(String plate, double length, int productionYear, int engineHp) {
        super(plate, length, productionYear);
        this.engineHp = engineHp;
    }

    public int getEngineHp() {
        return this.engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    @Override
    public double calculateModule() {
        return super.calculateModule() + this.engineHp;
    }


    @Override
    public String toString() {
        return super.toString() + 
            "\nEngine Hp: " + getEngineHp();
    }

}
