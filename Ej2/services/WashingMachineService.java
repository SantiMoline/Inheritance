package Ej2.services;

import java.util.Scanner;

import Ej2.entities.WashingMachine;

import static Ej2.Constants.*;

public final class WashingMachineService extends ApplianceService {

     /**
     * Create a new WashingMachine object. Uses de super createAppliance method and then fills the new attributes.
     * @param scan
     * @return
     */
    public WashingMachine createWashingMachine(Scanner scan) {
        WashingMachine wash = new WashingMachine();
        super.createAppliance(scan, wash);
        System.out.print("Load: ");
        double load = scan.nextDouble();
        scan.nextLine(); //Throaway scan.
        wash.setLoad(load);

        return wash;        
    }

    /**
     * Overload the finalPrice(Appliance app) method from Appliance class.
     * Did not overrided the method to avoid casting the Appliance object recieved as parameter into a Washing Machine.
     * Checks new conditions only valid to WashingMachine objects. Assigns final price according to those.
     * @param app
     */
    public void finalPrice(WashingMachine app) {
        super.finalPrice(app);
        if (app.getLoad() > WASHING_FLOOR_LOAD)
            app.setPrice(app.getPrice() + PRICE_EXTRA_LOAD);
        
    }
    
}
