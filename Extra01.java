import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Extra01.entities.Boat;
import Extra01.entities.Motorboat;
import Extra01.entities.Rent;
import Extra01.entities.Sailboat;
import Extra01.entities.Yacht;

public class Extra01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean active = true;
        System.out.println("-------------Welcome to RentABoat-------------");
        ArrayList<Boat> boats = new ArrayList<>();
        fillArray(boats);


        while (active) {
            showMenu();
            int opc = promptInput(scan);
            switch (opc) {
                case 1: 
                    System.out.println("Here are our available normal boats...");
                    showBoatsOfType(boats, "Boat");
                    break;
                case 2: 
                    System.out.println("Here are our available Sailboats...");
                    showBoatsOfType(boats, "Sailboat");
                    break;
                case 3:
                    System.out.println("Here are our available Motorized boats...");
                    showBoatsOfType(boats, "Motorboat");
                    break;     
                case 4:
                    System.out.println("Here are our available Yachts...");
                    showBoatsOfType(boats, "Yacht");
                    break;
                case 5: Rent rental = rentABoat(scan, boats);
                    System.out.println("The rental's price is: $" + rental.calculateRentPrice());
                    break;
                case 6:
                    System.out.println("Thanks for coming, until next time. ");
                    active = false;
                    break;
                default: System.out.println("Invalid option. Impossible to reach with the prompt method.");
            }
        }

        
    }

    public static void showMenu() {
        System.out.println("What kind of boat would you like to rent: ");
        System.out.println("1. See list of normal boats.");
        System.out.println("2. See list of sailboats.");
        System.out.println("3. See list of Motorized boats.");
        System.out.println("4. See list of Yacht.");
        System.out.println("5. Rent a boat by plate: ");
        System.out.println("6. Exit.");
    }

    public static int promptInput(Scanner scan) {
        while(true) {
            System.out.print("Choose an option (1-6): ");
            if (!scan.hasNextInt()) {
                scan.nextLine(); //To capture incorrect input.
                continue;
            }
            int opc = scan.nextInt();
            scan.nextLine(); //Throwaway scan.
            if (isInvalidOption(opc))
                continue;
            return opc;
        }
    }

    public static boolean isNullOrBlank(String string) {
        return string == null || string.isBlank();
    }

    public static boolean isInvalidOption(int opc) {
        return (opc < 1 || opc > 6);
    }

    public static void fillArray(ArrayList<Boat> boats) {
        boats.add(new Motorboat("M0T0R", 10, 1955, 250));
        boats.add(new Boat("C0M0N-B04T", 12, 1937));
        boats.add(new Motorboat("0NLY-M0T0R", 15, 1965, 325));
        boats.add(new Sailboat("S41L", 17, 1988, 3));
        boats.add(new Yacht("LUXURY", 33, 2010, 450, 4));
        boats.add(new Yacht("G0LD3N-B0Y", 44, 2018, 650, 6));
    }

    public static void showBoatsOfType(ArrayList<Boat> boats, String type) {
        for (Boat boat : boats) {
            if (boat.getClass().getSimpleName().equalsIgnoreCase(type)) {
                System.out.println(boat);
            }
        }
    }

    public static Boat searchByPlate(ArrayList<Boat> boats, String plate) {
        for (Boat boat : boats) {
            if (boat.getPlate().equalsIgnoreCase(plate))
                return boat;
        }
        return null;
    }

    public static String promptForPlate(Scanner scan) {
        while (true) {
            System.out.print("Please enter the plate of the boat you'd like to rent: ");
            String plate = scan.nextLine();
            if (!isNullOrBlank(plate))
                return plate;
            System.out.println("Plate cannot be null or blank. Try again...");
        }
    }

    public static Boat checkBoat(Scanner scan, ArrayList<Boat> boats) {
        while (true) {
            String plate = promptForPlate(scan);
            Boat boatToRent = searchByPlate(boats, plate);
            if (boatToRent == null) {
                System.out.println("We couldn't find a boat with that plate in our database. Try again...");
                continue;
            }
            return boatToRent;
        }               
    }

    public static LocalDate promptForEndDate(Scanner scan) {
        while (true) {
            System.out.println("Enter expiration date for the rent: ");
            String date = scan.nextLine();
            if (isNullOrBlank(date))
                continue;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date,formatter);
        }
    } 

    public static Rent rentABoat(Scanner scan, ArrayList<Boat> boats) {
        Boat boatToBeRented = checkBoat(scan, boats);
        LocalDate endDate = promptForEndDate(scan);
        System.out.println("Client's name: ");
        String name = scan.nextLine();
        
        return new Rent(name, 123456, LocalDate.now(), endDate, 10, boatToBeRented);
    }
}

/*
 * En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del amarre y el barco que lo ocupará.
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles, en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el precio final de su alquiler.
 */