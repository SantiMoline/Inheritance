package Extra03.entities;

import Extra03.enums.Gym;
import static Extra03.constants.HotelConstants.*;


public class HotelFiveStars extends HotelFourStars {
    private int conferenceRooms;
    private int suitRooms;
    private int limousines;


    public HotelFiveStars(String name, String address, String city, String managerName, int rooms, int beds, int floors, double roomPrice, Gym gym, String restaurant, int restaurantCapacity, int conferenceRooms, int suitRooms, int limousines) {
        super(name, address, city, managerName, suitRooms, beds, floors, roomPrice, gym, restaurant, restaurantCapacity);
        this.conferenceRooms = conferenceRooms;
        this.suitRooms = suitRooms;
        this.limousines = limousines;
    }

    public int getConferenceRooms() {
        return this.conferenceRooms;
    }

    public void setConferenceRooms(int conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public int getSuitRooms() {
        return this.suitRooms;
    }

    public void setSuitRooms(int suitRooms) {
        this.suitRooms = suitRooms;
    }

    public int getLimousines() {
        return this.limousines;
    }

    public void setLimousines(int limousines) {
        this.limousines = limousines;
    }

    private double bonusForLimousine() {
        return this.limousines * PRICE_LIMO;
    }

    @Override
    public double calculatePrice(){
        return (super.calculatePrice() + bonusForLimousine());
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nConference Rooms: " + getConferenceRooms() +
            "\nSuite Rooms='" + getSuitRooms() +
            "\nLimousines: " + getLimousines();
    }


}
