package Extra03.entities;

import Extra03.enums.Gym;
import static Extra03.constants.HotelConstants.*;

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


    private double bonusForRestaurant() {
        if (this.restaurantCapacity <= RESUTARANT_C_MAX_CAPACITY)
            return PRICE_RESTAURANT_C;
        if (this.restaurantCapacity > RESUTARANT_B_MAX_CAPACITY)
            return PRICE_RESTAURANT_A;
        return PRICE_RESTAURANT_B;
    }

    private double bonusForGym() {
        return Gym.A.equals(this.gym) ? PRICE_GYM_A : PRICE_GYM_B;
    }

    public double calculatePrice() {
        return (PRICE_ROOM + calculateHotelCapacity() + bonusForRestaurant() + bonusForGym());
    }

    public int calculateHotelCapacity() {
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
