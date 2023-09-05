package Ej2.services;

import java.util.Scanner;

import Ej2.entities.Appliance;
import Ej2.enums.Color;
import Ej2.enums.ElectricConsumption;
import static Ej2.Constants.*;

public abstract class ApplianceService {
    

    public ApplianceService() {
    }

    /**
     * Create a new Appliance object. Check if the Electric Consumption and Color are valid. If they're are not valid,
     * assings "F" as Electric Consumption and "White" as color.
     * @param scan  to read user's input.
     * @param app   Appliance to be created.
     * @return      
     */
    public Appliance createAppliance(Scanner scan, Appliance app) {
        System.out.print("Color: ");
        String colour = scan.nextLine();
        app.setColor(assignColor(colour));
        System.out.print("Electric Consumption: ");
        char ec = scan.next().charAt(0);
        app.setConsumption(assignConsumption(ec));
        System.out.print("Weight: ");
        double weight = scan.nextDouble();
        scan.nextLine(); //Throwaway scan.
        app.setWeight(weight);
        app.setPrice(BASE_PRICE);

        return app;
    }

    /**
     * Checks if the consumption corresponds to a valid value in the enum ElectricConsumption.
     * @param letter
     * @return  False if the consumption is not a valid one.
     */
    private boolean checkConsumption(char letter) {
        for (ElectricConsumption consumption : ElectricConsumption.values()) {
            if (consumption.toString().equalsIgnoreCase(String.valueOf(letter))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Assigns "F" when the electric consumption was not valid (not found in the enum ElectricConsumption)
     * @param letter
     * @return  ElectricConsumption.F when the electric consumption indicated was not a valid one.
     * Otherwise returns the ElectricConsumption value according to the letter recieved.
     */
    private ElectricConsumption assignConsumption(char letter) {
        return checkConsumption(letter) ? ElectricConsumption.valueOf(String.valueOf(letter).toUpperCase()) : ElectricConsumption.F;
    }

    /**
     * Checks if the color corresponds to a valid value in the enum Color.
     * @param colour
     * @return True if founded the corresponding Enum value. Otherwise, returns false.
     */
    private boolean checkColor(String colour) {
        for (Color color : Color.values()) {
            if (color.toString().equalsIgnoreCase(colour))
                return true;
        }
        return false;
    }

    /**
     * Assigns "WHITE" when the color was not valid (not found in the enum Color)
     * @param colour
     * @return  Color.WHITE when the color recieved was not a valid one.
     * Otherwise returns the Color value according to the string recieved.
     */
    private Color assignColor(String colour) {
        return checkColor(colour) ? Color.valueOf(colour.toUpperCase()) : Color.WHITE;
    }

    /**
     * Update the Appliance price using the current pricing rules (Pricing by consumption, pricing by weight).
     * @param app   The appliance that is going to get it's price updated.
     */
    protected void finalPrice(Appliance app) {
        updatePriceByConsumption(app);
        updatePriceByWeight(app);
    }

    /**
     * Updates the Appliance price according to it's ElectricConsumption.
     * @param app   The appliance that is going to get it's price updated.
     */
    private void updatePriceByConsumption(Appliance app) {
        switch (app.getConsumption().toString()) {
            case "A":
                app.setPrice(BASE_PRICE + 1_000);
                break;
            case "B":
                app.setPrice(BASE_PRICE + 800);
                break;
            case "C":
                app.setPrice(BASE_PRICE + 600);
                break;
            case "D":
                app.setPrice(BASE_PRICE + 500);
                break;
            case "E":
                app.setPrice(BASE_PRICE + 300);
                break;
            case "F":
                app.setPrice(BASE_PRICE + 100);
                break;
            default: System.out.println("Invalid consumption.");
        }
    }

    /**
     * Updates the Appliance price according to it's weight.
     * @param app   The appliance that is going to get it's price updated.
     */
    private void updatePriceByWeight(Appliance app) {
        double weight = app.getWeight();
        double price = app.getPrice();
        if (weight >= 80) {
            app.setPrice(price + 1000);
        } else if (weight >= 50) {
            app.setPrice(price + 500);
        } else if (weight >= 20) {
            app.setPrice(price + 500);
        } else {
            app.setPrice(price + 100);
        }
    }
}
