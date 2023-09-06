import java.util.ArrayList;

import Ej2.entities.Appliance;
import Ej2.entities.Tv;
import Ej2.entities.WashingMachine;
import Ej2.enums.Color;
import Ej2.enums.ElectricConsumption;
import Ej2.services.TvService;
import Ej2.services.WashingMachineService;


public class Ej3 {
    static TvService tvserv = new TvService();
    static WashingMachineService wmserv = new WashingMachineService();

    public static void main(String[] args) {
        System.out.println("Generating ArrayList of Appliances.......");
        ArrayList<Appliance> appliances = new ArrayList<>();
        System.out.println("Loading appliances................");
        appliances.add(new WashingMachine(500,Color.BLUE,ElectricConsumption.B, 400, 35));
        appliances.add(new Tv(500,Color.BLUE,ElectricConsumption.B, 7, 44, true));
        appliances.add(new WashingMachine(500,Color.WHITE,ElectricConsumption.A, 33, 25));
        appliances.add(new Tv(500,Color.GREY,ElectricConsumption.C, 21, 32, false));

        
        System.out.println("Updating prices......");
        updatePrices(appliances);

        double WashingMachTotalPrices = totalPriceByClass(appliances,"WashingMachine");
        double TvsTotalPrices = totalPriceByClass(appliances,"Tv");
        System.out.println("Total prices for Washing Machines: $" + WashingMachTotalPrices);
        System.out.println("Total prices for Tvs: $" + TvsTotalPrices);
        System.out.println("Total prices for Appliances: $" + (TvsTotalPrices + WashingMachTotalPrices));
    }

    public static void updatePrices(ArrayList<Appliance> apps) {
        for (int i = 0; i < apps.size(); i++) {
            if (apps.get(i) instanceof Tv) 
                tvserv.finalPrice((Tv) apps.get(i));
            else
                wmserv.finalPrice((WashingMachine) apps.get(i));
        }
    }

    public static double totalPriceByClass(ArrayList<Appliance> apps, String classToSum) {
        double total = 0;
        for (Appliance appliance : apps) {
            if(appliance.getClass().getSimpleName().equalsIgnoreCase(classToSum)) {
                total += appliance.getPrice();
            }
        }
        return total;
    }
}
