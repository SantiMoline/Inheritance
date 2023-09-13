package Extra03.entities;

public class Residency extends NonHotel {
    private int rooms;
    private boolean discounts;
    private boolean sportsGround;

    public Residency(String name, String address, String city, String managerName, boolean isPrivate, double surfaceArea, int rooms, boolean discounts, boolean sportsGround) {
        super(name, address, city, managerName, isPrivate, surfaceArea);
        this.rooms = rooms;
        this.discounts = discounts;
        this.sportsGround = sportsGround;
    }


    public int getRooms() {
        return this.rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean getDiscounts() {
        return this.discounts;
    }

    public void setDiscounts(boolean discounts) {
        this.discounts = discounts;
    }

    public boolean getSportsGround() {
        return this.sportsGround;
    }

    public void setSportsGround(boolean sportsGround) {
        this.sportsGround = sportsGround;
    }


    @Override
    public String toString() {
        return super.toString() +
            "\nRooms: " + getRooms() +
            "\nHas any discounts: " + getDiscounts() +
            "\nHas Sports Ground: " + getSportsGround();
    }

    



}
