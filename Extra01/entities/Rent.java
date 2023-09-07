package Extra01.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rent {
    private String name;
    private int clientId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int position;
    private Boat boat;


    public Rent(String name, int clientId, LocalDate startDate, LocalDate endDate, int position, Boat boat) {
        this.name = name;
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.boat = boat;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Boat getBoat() {
        return this.boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public double calculateRentPrice() {
        return (this.boat.calculateModule() * this.startDate.until(endDate, ChronoUnit.DAYS));
    }

}
