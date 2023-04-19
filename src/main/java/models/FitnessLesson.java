package models;

import java.util.List;
import java.util.Objects;

public class FitnessLesson {

    private final String name;
    private final FitnessType type;
    private final List<BookingDay> daysOpen;


    public FitnessLesson(FitnessType type, String name, List<BookingDay> daysOpen) {
        this.daysOpen = daysOpen;
        this.type = type;
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public FitnessType getType() {
        return type;
    }

    public int getPrice() {
        return type.price;
    }

    public List<BookingDay> getDaysOpen() {
        return daysOpen;
    }

    @Override
    public String toString() {
        return  name + " [" + type + "]\n" +
                "Fees: Rs." + getPrice() + '\n' +
                "Open: " + daysOpen + '\n';
    }


    public boolean isOpenOn(BookingDay bookingDay){
        return daysOpen.contains(bookingDay);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitnessLesson that = (FitnessLesson) o;
        return name.equals(that.name) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
