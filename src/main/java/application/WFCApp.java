package application;

import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static models.BookingDay.*;
import static models.BookingWeek.*;

public class WFCApp {

    static ArrayList<DailyBooking> bookings = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static Customer currentUser;

    static ArrayList<FitnessLesson> lessons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initData();

        int choice;

        while(true) {

            System.out.println("Select Your Choice:");

            System.out.println("1. Login");
            System.out.println("2. Exit");
            try {
                choice = in.nextInt();
            }catch (Exception e){
                choice = 0;
            }


            if (choice==1){
                System.out.println("Enter Your Phone Number: ");
                String phone = in.next();
                if (login(phone)){
                    start();
                }
            } else if (choice==2){
                System.exit(0);
            } else {
                System.out.println("Invalid Choice\n");
            }
        }
    }


    public static boolean login(String phone){
        for (Customer c : customers) {
            if (c.phone.equals(phone)) {
                currentUser = c;
                return true;
            }
        }
        return false;
    }



    public static void start(){

        System.out.println("Hello "+currentUser.name+" !");
        System.out.println("─────────────[ Welcome to Weekend Fitness Club ]─────────────");

        Scanner in = new Scanner(System.in);
        int choice = 0;

        while(choice!=3) {
            System.out.println("\nSelect Your Choice:");

            System.out.println("1. Book a Lesson");
            System.out.println("2. My Bookings");
            System.out.println("3. Logout");

            choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Booking a lesson...");
                    break;
                case 2:
                    viewUserBookings(currentUser);
                    break;
                default:
                    System.out.println("Invalid Choice\n");

            }


        }




    }



    void showAvailableLessons(BookingDay day){

    }

    void showAvailableLessons(FitnessType fitnessType){

    }

    void printReports(){

        /*for 4 weeks*/
    }

    static boolean canBookLesson(FitnessLesson lesson, BookingDay day, BookingWeek week){
        int bookingCount = 0;
        for (DailyBooking b : bookings){
            if(b.lesson.equals(lesson)){
                bookingCount++;
            }
            if (bookingCount == 5) {
                System.out.println("Lesson is Full");
                return false;
            }
        }
        bookingCount=0;


        for (DailyBooking b : bookings){
            if(b.bookingWeek == week && day == b.bookingDay){
                bookingCount++;
            }
            if (bookingCount == 2) {
                System.out.println(" Booking is Full on "+ day+" - "+week);
                return false;
            }
        }

        return true;
    }

    static boolean bookLesson(FitnessLesson lesson, Customer customer, BookingDay day, BookingWeek week){
        if(canBookLesson(lesson, day, week)){
            if(isAlreadyLessonBooked(lesson, customer, day, week)){
                System.out.println("This Lesson is Already booked");
            }else{
                bookings.add(new DailyBooking(day, week, lesson, customer));
                return true;
            }
        }
        return false;
    }

    static boolean isAlreadyLessonBooked(FitnessLesson lesson, Customer customer, BookingDay day, BookingWeek week){
        for (DailyBooking b : bookings){
            if(b.customer.equals(customer) && b.lesson.equals(lesson) && day == b.bookingDay && week == b.bookingWeek)
                return true;
        }
        return false;
    }

    static void viewUserBookings(Customer customer){
        System.out.println("My Bookings:");
        for (DailyBooking b:bookings) {
            if(b.customer.phone.equals(customer.phone)){
                System.out.println(b);
            }
        }
    }



    private static void initData(){
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Lesson-1", 1500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Lesson-2", 2000, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Lesson-3", 2500, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.BODY_SCULPT,"Lesson-4", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Lesson-5", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Lesson-6", 270, new ArrayList<>(Arrays.asList(Saturday, Sunday))));

        customers.add(new Customer("Shoaib", "Hyderabad", "03123934654", 71, 25));
        customers.add(new Customer("Amjad", "Hyderabad", "03000838330", 68, 27));
        customers.add(new Customer("Majid", "Hyderabad", "03029142318", 69, 26));
        customers.add(new Customer("Bilal", "Hyderabad", "03203538328", 86, 32));
        customers.add(new Customer("Faraz", "Bandhi", "03081324743", 79, 23));
        customers.add(new Customer("Fahad", "Bandhi", "0300907634", 95, 35));
        customers.add(new Customer("Aftab", "Kotri", "03002335464", 127, 29));
        customers.add(new Customer("Rafi", "Jamshoro", "03049464839", 77, 26));
        customers.add(new Customer("Shahbaz", "Jamshoro", "03343852729", 72, 28));
        customers.add(new Customer("Zohaib", "Latifabad", "03253264937", 69, 24));



        boolean isBooked;

        //Bookings for Saturday
        isBooked = bookLesson(lessons.get(0), customers.get(0), Saturday, Week1);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(0), customers.get(1), Saturday, Week1);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(1), customers.get(4), Saturday, Week4);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(2), customers.get(5), Saturday, Week2);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(5), customers.get(6), Saturday, Week3);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(4), customers.get(7), Saturday, Week4);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(1), customers.get(9), Saturday, Week3);
        if(isBooked) bookings.get(bookings.size()-1).attend();

        //Bookings for Sunday
        isBooked = bookLesson(lessons.get(3), customers.get(0), Sunday, Week1);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(1), customers.get(1), Sunday, Week1);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(3), customers.get(2), Sunday, Week2);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(4), customers.get(3), Sunday, Week3);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(5), customers.get(4), Sunday, Week4);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(3), customers.get(5), Sunday, Week2);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(4), customers.get(6), Sunday, Week3);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(5), customers.get(1), Sunday, Week4);
        if(isBooked) bookings.get(bookings.size()-1).attend();



    }
}
