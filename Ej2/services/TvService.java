package Ej2.services;

import java.util.Scanner;

import Ej2.entities.Tv;
import static Ej2.Constants.*;

public final class TvService extends ApplianceService {
    
    /**
     * Create a new Tv object. Uses de super createAppliance method and then fills the new attributes.
     * @param scan
     * @return
     */
    public Tv createTv(Scanner scan) {
        Tv tv = new Tv();
        super.createAppliance(scan, tv);
        System.out.print("Resolution: ");
        double reso = scan.nextDouble();
        scan.nextLine(); //Throwaway scan.
        tv.setResolution(reso);
        System.out.print("Has tdt (Y/N)? ");
        String tdt = scan.nextLine();
        tv.setTdt(tdt.equalsIgnoreCase("Y"));

        return tv;
    }

    /**
     * Overload the finalPrice method from Appliance class.
     * Did not overrided the method to avoid casting the Appliance object recieved as parameter into a Tv.
     * Checks new conditions only valid to Tvs objects. Assigns final price according to those.
     * @param tv
     */
    public void finalPrice(Tv tv) {
        super.finalPrice(tv);
        if (tv.getResolution() > TV_FLOOR_RESOLUTION)
            tv.setPrice(tv.getPrice() * PRICING_RATE_BIG_RESOLUTION);
        if (tv.getTdt())
            tv.setPrice(tv.getPrice() + PRICE_TDT);
    }
}
