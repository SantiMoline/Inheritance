package Extra03.entities;

/**
 * Class to instantiate Camping. Extends NonHotel class.
 */
public class Camping extends NonHotel {
    private int maxTents;
    private int bathrooms;
    private boolean hasRestaurant;

    public Camping(String name, String address, String city, String managerName, boolean isPrivate, double surfaceArea, int maxTents, int bathrooms, boolean hasRestaurant) {
        super(name, address, city, managerName, isPrivate, surfaceArea);
        this.maxTents = maxTents;
        this.bathrooms = bathrooms;
        this.hasRestaurant = hasRestaurant;
    }

    public int getMaxTents() {
        return this.maxTents;
    }

    public void setMaxTents(int maxTents) {
        this.maxTents = maxTents;
    }

    public int getBathrooms() {
        return this.bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean getHasRestaurant() {
        return this.hasRestaurant;
    }

    public void setHasRestaurant(boolean hasRestaurant) {
        this.hasRestaurant = hasRestaurant;
    }


    @Override
    public String toString() {
        return super.toString() +
            "\nMax Tents: " + getMaxTents() +
            "\nBathrooms: " + getBathrooms() +
            "\nHas Restaurant='" + getHasRestaurant();
    }


}
