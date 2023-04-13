package application;

import models.*;

import java.util.ArrayList;
import java.util.Arrays;

import static models.BookingDay.Saturday;
import static models.BookingDay.Sunday;

public class WFCApp {

    static ArrayList<DailyBooking> bookings = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();

    static ArrayList<FitnessLesson> lessons = new ArrayList<>();

    public static void main(String[] args) {
        initData();


//        System.out.println(l1);
//        System.out.println(l3.isOpenOn(Saturday));


        viewUserBookings(customers.get(1));





    }


    void showAvailableLessons(BookingDay day){}

    void showAvailableLessons(FitnessType fitnessType){}

    void printReports(){
        /*for 4 weeks*/
    }

    static boolean canBookLesson(FitnessLesson lesson, Customer customer){
        /*add max 5 bookings*/
        return true;
    }

    static void bookLesson(FitnessLesson lesson, Customer customer){
        if(canBookLesson(lesson,customer)){
            if(isAlreadyLessonBooked(lesson,customer)){
                System.out.println("This Lesson is Already booked");
            }else{
                bookings.add(new DailyBooking(
                        Saturday,
                        lesson,
                        customer
                ));
            }
        }
    }
    static boolean isAlreadyLessonBooked(FitnessLesson lesson, Customer customer){

        return true;
    }
    static void viewUserBookings(Customer customer){
        System.out.println("My Bookings:");
        for (DailyBooking b:bookings) {
            if(b.customer.phone.equals(customer.phone)){
                System.out.println(b.lesson.name+" ("+b.lesson.type + ") on " + b.bookingDay);
            }
        }
    }



    private static void initData(){
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Fitness-1", 1500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Fitness-2", 2000, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Fitness-3", 2500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.BODY_SCULPT,"Fitness-4", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Fitness-1", 1500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Fitness-2", 2000, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Fitness-3", 2500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Fitness-4", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Fitness-1", 1500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Fitness-2", 2000, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Fitness-3", 2500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.BODY_SCULPT,"Fitness-4", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Fitness-1", 1500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Fitness-2", 2000, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Fitness-3", 2500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.BODY_SCULPT,"Fitness-4", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));

        customers.add(new Customer("Amjad", "Hyderabad", "03000838380", 68, 27));
        customers.add(new Customer("Majid", "Hyderabad", "03029142318", 69, 26));
        customers.add(new Customer("Bilal", "Hyderabad", "03203538328", 86, 32));
        customers.add(new Customer("Faraz", "Bandhi", "03081324743", 79, 23));
        customers.add(new Customer("Fahad", "Bandhi", "0300907634", 95, 35));
        customers.add(new Customer("Aftab", "Kotri", "03002335464", 127, 29));
        customers.add(new Customer("Rafi", "Jamshoro", "03049464839", 77, 26));






//        bookLesson(lessons.get(0), customers.get(0));
        bookings.add(new DailyBooking(Sunday, lessons.get(0), customers.get(0)));
        bookings.get(bookings.size()-1).attend();
        bookings.add(new DailyBooking(Sunday, lessons.get(0), customers.get(1)));
        bookings.get(bookings.size()-1).attend();
        bookings.add(new DailyBooking(Sunday, lessons.get(1), customers.get(0)));
        bookings.get(bookings.size()-1).attend();
        bookings.add(new DailyBooking(Sunday, lessons.get(2), customers.get(0)));
        bookings.get(bookings.size()-1).attend();
        bookings.add(new DailyBooking(Sunday, lessons.get(3), customers.get(0)));
        bookings.get(bookings.size()-1).attend();
        bookings.add(new DailyBooking(Sunday, lessons.get(3), customers.get(1)));
        bookings.get(bookings.size()-1).attend();
        bookings.add(new DailyBooking(Sunday, lessons.get(3), customers.get(1)));
        bookings.get(bookings.size()-1).attend();

//        bookings.add(new DailyBooking(Saturday, l1, c1, false));
//        bookings.add(new DailyBooking(Saturday, l1, c1, false));
//        bookings.add(new DailyBooking(Saturday, l1, c1, false));
//        bookings.add(new DailyBooking(Saturday, l1, c1, false));





    }
}
