import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import Extra03.entities.Accomodation;
import Extra03.entities.Camping;
import Extra03.entities.HotelFiveStars;
import Extra03.entities.HotelFourStars;
import Extra03.entities.Residency;
import Extra03.enums.Gym;
import Extra03.utilities.HotelFourStarsComparator;

import static Extra03.constants.MainConstants.*;


public class Extra03 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ArrayList<Accomodation> accomodations = new ArrayList<>();
        fillArray(accomodations);
        boolean active = true;
        System.out.println("----------Welcome to Airbnb catalogue----------");

        while (active) {
            showMenu();
            int opc = promptForOption(scan);
            switch(opc) {
                case 1:
                    System.out.println("Showing registered accomodations: ");
                    showAccomodations(accomodations);
                    break;
                case 2:
                    System.out.println("Showing registered Hotels (from most expensive to cheapest): ");
                    showHotels(accomodations);
                    break;
                case 3:
                    System.out.println("Showing Campings with restaurants: ");
                    showCampingsWithRestaurants(accomodations);
                    break;
                case 4:
                    System.out.println("Showing Residencies with active discounts: ");
                    showResidenciesWithDiscounts(accomodations);
                    break;
                case 5:
                    System.out.println("Hope you could find what you were looking for. Until next time!");
                    active = false;
                    break;
            }
        }
    }

    /**
     * Fills the array with different accomodations. Using HotelFourStars, HotelFiveStars, Residency & Camping classes.
     * @param accomodations     (ArrayList used in Main to store the different accomodation.)
     */
    public static void fillArray(ArrayList<Accomodation> accomodations) {
        accomodations.add(new HotelFourStars("Four Stars", "Las Heras 2020", "CABA", "Rodolfo", 20, 50, 10, 45.5, Gym.A, "El de Donato", 55)); 
        accomodations.add(new HotelFourStars("Four Stars", "Av. Rivadavia 1010", "CABA", "Juan", 12, 24, 5, 25.7, Gym.B, "Burguer King", 32)); 
        accomodations.add(new HotelFourStars("Four Stars", "Av. Independencia 900", "CABA", "Pepa", 10, 18, 4, 15.5, Gym.B, "Tobara x 200", 15)); 
        accomodations.add(new HotelFiveStars("Sheraton", "Libertador 750", "CABA", "Alfonso", 55, 80, 20, 105.50, Gym.A, "Betular's Delicatessen", 60, 2, 5, 3));
        accomodations.add(new HotelFiveStars("4 seasons", "Alvear 750", "CABA", "Martina", 35, 60, 10, 99.50, Gym.A, "Martitegui's Vip Restaurant", 25, 1, 4, 1));
        accomodations.add(new HotelFiveStars("Deluxe Petit Hotel", "Libertador 750", "CABA", "Josefina", 14, 20, 4, 135.50, Gym.A, "Deluxe Small Kitchen", 15, 1, 1, 2));
        accomodations.add(new Residency("Hostel Residency", "Los Incas 1810", "Mar del Plata", "Martín", true, 155, 8, false, true));
        accomodations.add(new Residency("Residency 212", "Libertador 2010", "Bariloche", "Cinthia", true, 255, 15, true, false));
        accomodations.add(new Camping("Full Nature Camping", "Ruta Nº 8 KM 29,5", "Córdoba", "Pepe", false, 1250, 55, 4, true));
        accomodations.add(new Camping("Discovery Camping", "Ruta Nº 12 KM 159,5", "San Martín de los Andes", "Santiago", true, 2250, 105, 10, true));
    }

    /**
     * Prints in console the menu with the available options.
     */
    public static void showMenu() {
        System.out.println("\n\n\tWhat would you like to do? ");
        System.out.println("1. Show all the available Accomodations.");
        System.out.println("2. Show all Hotels.");
        System.out.println("3. Show every Camping with restaurant.");
        System.out.println("4. Show every Residency with active discounts.");
        System.out.println("5. Exit.");
    }

    /**
     * Prints every Accomodation stored in the ArrayList.
     * @param accomodations (ArrayList used to store every accomodation.)
     */
    public static void showAccomodations(ArrayList<Accomodation> accomodations) {
        for (Accomodation accomodation : accomodations) {
            System.out.println(accomodation);
        }
    }

    /**
     * Asks the user for an int input and checks if it's valid. In case it's not, asks again until the user choose a valid int.
     * @param scan  Scanner to read input.
     * @return      A valid int that corresponds with an available option in the menu.
     */
    public static int promptForOption(Scanner scan) {
        while (true) {
            if (!scan.hasNextInt()) {
                scan.nextLine(); //To capture invalid input.
                continue;
            }
            int opc = scan.nextInt();
            if (isInvalidOption(opc))
                continue;
            return opc;
        }
    }

    /**
     * Checks if an int is between the 
     * @param opc
     * @return
     */
    public static boolean isInvalidOption(int opc) {
        return (opc < MIN_OPTION || opc > MAX_OPTION);
    }

    /**
     * Shows every registered hotel.
     * @param accomodations (ArrayList used to store every accomodation.)
     */
    public static void showHotels(ArrayList<Accomodation> accomodations) {
        TreeSet<HotelFourStars> hotels = getHotels(accomodations);
        if (hotels.size() > 0) {
            for (HotelFourStars hotel : hotels) {
                System.out.println(hotel);
            }
        } else {
            System.out.println("Sorry! There are no hotels registered in our catalogue.");
        }
    }

    private static TreeSet<HotelFourStars> getHotels(ArrayList<Accomodation> accomodations) {
        TreeSet<HotelFourStars> hotels = new TreeSet<>(HotelFourStarsComparator.compareByPrice);
        
        for (Accomodation accomodation : accomodations) {
            if (accomodation instanceof HotelFourStars)
                hotels.add((HotelFourStars) accomodation);   
        }
        return hotels;
    }

    /**
     * Shows every Camping with restaurant inside the facility.
     * @param accomodations (ArrayList used to store every accomodation.)
     */
    public static void showCampingsWithRestaurants(ArrayList<Accomodation> accomodations) {
        for (Accomodation accomodation : accomodations) {
            if (accomodation instanceof Camping) {
                Camping currentCamping = (Camping) accomodation;
                if (currentCamping.getHasRestaurant()) {
                    System.out.println(currentCamping);
                }
            }
        }
    }

    /**
     * Shows every Residency with available discounts.
     * @param accomodations (ArrayList used to store every accomodation.)
     */
    public static void showResidenciesWithDiscounts(ArrayList<Accomodation> accomodations) {
        for (Accomodation accomodation : accomodations) {
            if (accomodation instanceof Residency) {
                Residency currentResidency = (Residency) accomodation;
                if(currentResidency.getDiscounts())
                    System.out.println(currentResidency);
            }
        }
    }

}
