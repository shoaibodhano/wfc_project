package models;

import java.util.List;

public class FitnessLesson {

    public final String name;
    public final FitnessType type;
    public final int price;
    private final List<BookingDay> daysOpen;


    public FitnessLesson(FitnessType type, String name, int price, List<BookingDay> daysOpen) {
        this.daysOpen = daysOpen;
        this.type = type;
        this.name = name;
        this.price = price;
    }



    @Override
    public String toString() {
        return "name: " + name + '\n' +
                "type: " + type + '\n' +
                "price: " + price + '\n' +
                "daysOpen: " + daysOpen + '\n';
    }


    public boolean isOpenOn(BookingDay bookingDay){
        return daysOpen.contains(bookingDay);
    }
}