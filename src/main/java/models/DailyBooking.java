package models;

public class DailyBooking {

    public final BookingDay bookingDay;
    public final FitnessLesson lesson;
    public final Customer customer;
    private boolean attended;

    public DailyBooking(BookingDay bookingDay, FitnessLesson lesson, Customer customer) {
        this.bookingDay = bookingDay;
        this.lesson = lesson;
        this.customer = customer;
        this.attended = false;
    }

    public void attend(){
        attended = true;
    }
    public boolean isAttended(){
        return attended;
    }
}
