package Extra03.entities;

import Extra03.enums.Gym;
import static Extra03.constants.HotelConstants.*;

/**
 * Class to instantiate the first type of hotels available in these project. Extends Accomodation class.
 */
public class HotelFourStars extends Accomodation{
    private int rooms;
    private int beds;
    private int floors;
    private double roomPrice;
    private Gym gym;
    private String restaurant;
    private int restaurantCapacity;


    public HotelFourStars(String name, String address, String city, String managerName, int rooms, int beds, int floors, double roomPrice, Gym gym, String restaurant, int restaurantCapacity) {
        super(name, address, city, managerName);
        this.rooms = rooms;
        this.beds = beds;
        this.floors = floors;
        this.roomPrice = roomPrice;
        this.gym = gym;
        this.restaurant = restaurant;
        this.restaurantCapacity = restaurantCapacity;
    }

    public int getRooms() {
        return this.rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBeds() {
        return this.beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getFloors() {
        return this.floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getRoomPrice() {
        return this.roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Gym getGym() {
        return this.gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public String getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public int getRestaurantCapacity() {
        return this.restaurantCapacity;
    }

    public void setRestaurantCapacity(int restaurantCapacity) {
        this.restaurantCapacity = restaurantCapacity;
    }


    /**
     * Calculates the extra price of the Hotel calling the method, according to the specifications of the restaurant it has.
     * @return  The extra price to be added to the room's price, according to the inhouse restaurant's characteristics.
     */
    private double bonusForRestaurant() {
        if (this.restaurantCapacity <= RESUTARANT_C_MAX_CAPACITY)
            return PRICE_RESTAURANT_C;
        if (this.restaurantCapacity > RESUTARANT_B_MAX_CAPACITY)
            return PRICE_RESTAURANT_A;
        return PRICE_RESTAURANT_B;
    }

    /**
     * Calculates the extra price of the Hotel calling the method, according to the specifications of the gym it has.
     * @return  The extra price to be added to the room's price, according to the inhouse gym's characteristics.
     */
    private double bonusForGym() {
        return Gym.A.equals(this.gym) ? PRICE_GYM_A : PRICE_GYM_B;
    }

    /**
     * Calculates the total price of the Hotel calling the method, according to it's facilities.
     * @return  The total price of the Hotel's room, according to the Hotel facilites.
     */
    public double calculatePrice() {
        return (PRICE_ROOM + calculateHotelCapacity() + bonusForRestaurant() + bonusForGym());
    }

    /**
     * Calculates the hotel capacity considering it's rooms, floors and beds.
     * @return amount of beds available inside the hotel.
     */
    private int calculateHotelCapacity() {
        return this.getBeds() * this.getFloors() * this.getRooms();
    }


    @Override
    public String toString() {
        return super.toString() + 
            "\nRooms: " + getRooms() +
            "\nBeds: " + getBeds() +
            "\nFloors: " + getFloors() +
            "\nRoom Price: " + getRoomPrice() +
            "\nGym: " + getGym() +
            "\nRestaurant: " + getRestaurant() + 
            "\nRestaurant Capacity: " + getRestaurantCapacity();
    }


}
