package models;

public class DailyBooking {

    private final BookingDay bookingDay;
    private final BookingWeek bookingWeek;
    private final FitnessLesson lesson;
    private final Customer customer;
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
        return lesson.getName() + " [" + lesson.getType() + "] on (" + bookingDay + "/" + bookingWeek + ") - " + (attended ? "Attended" : "Not Attended");
    }

    public String getReport(){
        return customer.getName()+" - "+lesson.getName()+" ("+lesson.getType() + ") @Rs."+lesson.getPrice();
    }

    public BookingDay getBookingDay() {
        return bookingDay;
    }

    public BookingWeek getBookingWeek() {
        return bookingWeek;
    }

    public FitnessLesson getLesson() {
        return lesson;
    }

    public Customer getCustomer() {
        return customer;
    }
}
