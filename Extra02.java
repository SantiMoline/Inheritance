import java.util.ArrayList;

import Extra02.entities.Building;
import Extra02.entities.SportsCenter;
import Extra02.entities.OfficeBuilding;
import Extra02.enums.Roof;

public class Extra02 {
    public static void main(String[] args) {
        ArrayList<Building> buildings = new ArrayList<>();
        fillArray(buildings);
        showAreaAndVolume(buildings);
        System.out.println("Amount of indoor sportscenter: " + countSportsCenterByRoof(buildings, Roof.INDOOR));
        System.out.println("Amount of outdoor sportscenter: " + countSportsCenterByRoof(buildings, Roof.OUTDOOR));
        System.out.println("The office's capacities are: ");
        showCapacityPerOffice(buildings);
    }


    public static void fillArray(ArrayList<Building> buildings) {
        buildings.add(new SportsCenter(15,10,10,"Megatlon",Roof.INDOOR));
        buildings.add(new SportsCenter(2,55,60,"GEBA",Roof.OUTDOOR));
        buildings.add(new OfficeBuilding(25,25,25,4,6,11));
        buildings.add(new OfficeBuilding(48,20,40,7,7,20));
    }

    public static void showAreaAndVolume(ArrayList<Building> buildings) {
        for (Building building : buildings) {
            System.out.println("This " + building.getClass().getSimpleName() + " area is: " + building.calculateArea());
            System.out.println("This " + building.getClass().getSimpleName() + " volume is: " + building.calculateVolume());
        }
    }
    
    public static int countSportsCenterByRoof(ArrayList<Building> buildings, Roof roof) {
        int count = 0;
        for (Building building : buildings) {
            
            if(building instanceof SportsCenter) {
                if (((SportsCenter)building).getRoof().equals(roof))
                count++;
            }
        }
        return count;
    }

    public static void showCapacityPerOffice(ArrayList<Building> buildings) {
        for (Building building : buildings) {
            if (building instanceof OfficeBuilding) {
                ((OfficeBuilding) building).showBuildingCapacity();
            }
        }
    }
}
