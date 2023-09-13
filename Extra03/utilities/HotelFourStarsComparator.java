package Extra03.utilities;

import java.util.Comparator;

import Extra03.entities.HotelFourStars;

/**
 * Class to store Hotel comparators.
 */
public class HotelFourStarsComparator {
    
    /**
     * Allows to order HotelFourStars objects by price (in descending order).
     */
    public static Comparator<HotelFourStars> compareByPrice = new Comparator<HotelFourStars>() {
        @Override
        public int compare (HotelFourStars hotel1, HotelFourStars hotel2) {
            if (hotel1.getRoomPrice() - hotel2.getRoomPrice() > 0) 
                return -1;
            else if (hotel1.getRoomPrice() - hotel2.getRoomPrice() < 0)
                return 1;
            else
                return 0;
        }
    };
}
