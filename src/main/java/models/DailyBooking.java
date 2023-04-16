package models;

public class DailyBooking {

    public final BookingDay bookingDay;
    public final BookingWeek bookingWeek;
    public final FitnessLesson lesson;
    public final Customer customer;
    private boolean attended;

    public DailyBooking(BookingDay bookingDay, BookingWeek bookingWeek, FitnessLesson lesson, Customer customer) {
        this.bookingDay = bookingDay;
        this.lesson = lesson;
        this.customer = customer;
        this.bookingWeek = bookingWeek;
        this.attended = false;
    }

    public void attend(){
        attended = true;
    }
    public boolean isAttended(){
        return attended;
    }


    @Override
    public String toString() {
        return lesson.name+" ("+lesson.type + ") on " + bookingDay + " - "+bookingWeek;
    }
}
