package application;

import models.*;
import utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static models.BookingDay.*;
import static models.BookingWeek.*;

public class WFCApp {

    static ArrayList<DailyBooking> bookings = new ArrayList<>();
    static ArrayList<DailyBooking> userBookings = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static Customer currentUser;

    static ArrayList<FitnessLesson> lessons = new ArrayList<>();
    static ArrayList<FitnessLesson> filteredLessons = new ArrayList<>();

    public static void main(String[] args) {
        initData();

        int choice;

        while(true) {

            System.out.println("Select Your Choice:");

            System.out.println("1. Login");
//            System.out.println("2. Print Report");
            System.out.println("0. Exit");
            choice = getChoice();
//            choice = 1;

            if (choice==1){
                System.out.println("Enter Your Phone Number: ");
                String phone = "03000838330";System.out.println("03000838330");
//                String phone = in.next();
                if (login(phone)){
                    start();
                }
//            } else if (choice==2){
//                printReport();
            } else if (choice==0){
                System.exit(0);
            } else {
                System.out.println("Invalid Choice\n");
            }
        }
    }

    public static int getChoice(){
        try {
            return new Scanner(System.in).nextInt();
        }catch (Exception e){
            return  -1;
        }
    }


    public static boolean login(String phone){
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {
                currentUser = c;
                return true;
            }
        }
        return false;
    }



    public static void start(){

        System.out.println("Hello "+currentUser.getName()+" !");
        System.out.println("─────────────[ Welcome to Weekend Fitness Club ]─────────────");

        int choice = -1;

        while(choice!=0) {
            System.out.println("\nSelect Your Choice:");

            System.out.println("1. Book a group fitness lesson");
            System.out.println("2. Attend a lesson");
            System.out.println("3. Change a booking");
            System.out.println("4. Cancel a booking");
            System.out.println("5. My Bookings");
            System.out.println("6. Monthly lesson report");
//            System.out.println("5. Monthly champion fitness type report");
            System.out.println("0. Logout");

            choice = getChoice();

            switch (choice){
                case 1: // Book a group fitness lesson - Done
                    System.out.println("View Available Lessons:");
                    System.out.println("1. By Date");
                    System.out.println("2. By FitnessType");
                    choice = getChoice();
                    if (choice == 1){
                        System.out.println("Select Day:");
                        System.out.println("1. Saturday");
                        System.out.println("2. Sunday");
                        choice = getChoice();
                        if (choice==1 ){
                            showAvailableLessons(Saturday);
                            selectLessonToBook(null);
                        }else if (choice==2){
                            showAvailableLessons(Sunday);
                            selectLessonToBook(null);
                        }else {
                            System.out.println("Invalid Day...!");
                        }
                    } else if (choice == 2) {
                        System.out.println("Select Type:");
                        for (int i = 0 ;i< FitnessType.values().length; i++) {
                            System.out.println((i+1)+". "+FitnessType.values()[i]);
                        }
                        choice = getChoice();
                        if(choice > 0 && choice <= FitnessType.values().length) {
                            showAvailableLessons(FitnessType.values()[choice-1]);
                            selectLessonToBook(null);
                        } else {
                            System.out.println("Invalid Type...!");
                        }
                    }

                    break;
                case 2: // Attend a Lesson - Done
                    viewUserBookings(currentUser);
                    attendALesson();
                    break;
                case 3: // Change a booking
                    viewUserBookings(currentUser);
                    changeABooking();
                    break;
                case 4: // Cancel a booking - Done
                    viewUserBookings(currentUser);
                    cancelABooking();
                    break;
                case 5: //My Bookings - Done
                    viewUserBookings(currentUser);
                    for (DailyBooking b:userBookings) {
                        System.out.println(b);
                    }
                    break;
                case 6: //Monthly lesson report - Done
                    printReport();
                    break;
                case 0: break; // logout - Done
                default:
                    System.out.println("Invalid Choice\n");

            }
        }
    }






    // Done
    static void cancelABooking(){
        ArrayList<DailyBooking> pendingBookings = new ArrayList<>();
        for (DailyBooking b : userBookings) {
            if (!b.isAttended())
                pendingBookings.add(b);
        }
        if (pendingBookings.size()==0){
            System.out.println("You don't have pending Bookings..");
            return;
        }
        System.out.println("Select a Booking to Cancel:");


        for (int i = 0; i < pendingBookings.size(); i++) {
            System.out.println((i+1)+". "+pendingBookings.get(i)+'\n');
        }

        int choice =  getChoice();
        if(choice > 0 && choice <= pendingBookings.size()) {
            DailyBooking b = pendingBookings.get(choice-1);
            bookings.remove(b);
            System.out.println("Booking cancelled Successfully !");
        } else {
            System.out.println("Invalid Choice...!");
        }

    }

    static void changeABooking(){
        ArrayList<DailyBooking> pendingBookings = new ArrayList<>();
        for (DailyBooking b : userBookings) {
            if (!b.isAttended())
                pendingBookings.add(b);
        }
        if (pendingBookings.size()==0){
            System.out.println("You don't have pending Bookings..");
            return;
        }

        System.out.println("Select a Booking to Change:");

        for (int i = 0; i < pendingBookings.size(); i++) {
            System.out.println((i+1)+". "+pendingBookings.get(i)+'\n');
        }

        DailyBooking b=null;
        int choice =  getChoice();
        if(choice > 0 && choice <= pendingBookings.size()) {
            b = pendingBookings.get(choice-1);
        } else {
            System.out.println("Invalid Choice...!");
        }

        if(b==null) return;

        System.out.println("View Available Lessons to Change Booking:");
        System.out.println("1. By Date");
        System.out.println("2. By FitnessType");
        choice = getChoice();
        if (choice == 1){
            System.out.println("Select Day:");
            System.out.println("1. Saturday");
            System.out.println("2. Sunday");
            choice = getChoice();
            if (choice==1 ){
                showAvailableLessons(Saturday);
                selectLessonToBook(b);
            }else if (choice==2){
                showAvailableLessons(Sunday);
                selectLessonToBook(b);
            }else {
                System.out.println("Invalid Day...!");
            }
        } else if (choice == 2) {
            System.out.println("Select Type:");
            for (int i = 0 ;i< FitnessType.values().length; i++) {
                System.out.println((i+1)+". "+FitnessType.values()[i]);
            }
            choice = getChoice();
            if(choice > 0 && choice <= FitnessType.values().length) {
                showAvailableLessons(FitnessType.values()[choice-1]);
                selectLessonToBook(b);
            } else {
                System.out.println("Invalid Type...!");
            }
        }


    }

    // Done
    static void attendALesson(){
        ArrayList<DailyBooking> pendingBookings = new ArrayList<>();
        for (DailyBooking b : userBookings) {
            if (!b.isAttended())
                pendingBookings.add(b);
        }
        if (pendingBookings.size()==0){
            System.out.println("You don't have pending Lessons to Attend");
            return;
        }
        System.out.println("Select a Lesson to Attend:");

        for (int i = 0; i < pendingBookings.size(); i++) {
            System.out.println((i+1)+". "+pendingBookings.get(i)+'\n');
        }

        int choice =  getChoice();
        if(choice > 0 && choice <= pendingBookings.size()) {
            DailyBooking b = pendingBookings.get(choice-1);
            b.attend();
            System.out.println("Lesson Attended Successfully !");
            rateLesson(b.getLesson());
        } else {
            System.out.println("Invalid Choice...!");
        }


    }

    static void rateLesson(FitnessLesson l){

        //TODO implement it.
        System.out.println("Rate the "+l.toString().split("\n")[0]);

    }

    // Done
    static void showAvailableLessons(BookingDay day){
        filteredLessons.clear();
        for (FitnessLesson l : lessons) {
            if (l.isOpenOn(day)) {
                filteredLessons.add(l);
                System.out.println(filteredLessons.size()+". "+l.toString().replaceAll("\n","\t"));
            }
        }
    }

    // Done
    static void showAvailableLessons(FitnessType fitnessType){
        filteredLessons.clear();
        for (FitnessLesson l : lessons) {
            if (l.getType() == fitnessType) {
                filteredLessons.add(l);
                System.out.println(filteredLessons.size()+". "+l.toString().replaceAll("\n","\t"));
            }
        }
    }

    static void selectLessonToBook(DailyBooking currentBooking){
        System.out.println("\nSelect a Lesson to Book\n");
        int choice = getChoice();
        if(choice > 0 && choice <= filteredLessons.size()) {
            FitnessLesson lesson = filteredLessons.get(choice-1);
            System.out.println("Select Week:");
            System.out.println("1. Week-1");
            System.out.println("2. Week-2");
            System.out.println("3. Week-3");
            System.out.println("4. Week-4");
            choice = getChoice();
            if (choice<=4 && choice>=1){
                BookingWeek week = BookingWeek.values()[choice-1];
                System.out.println("Select Day:");
                System.out.println("1. Saturday");
                System.out.println("2. Sunday");
                choice = getChoice();
                if (choice == 1 || choice==2){
                    BookingDay day = BookingDay.values()[choice-1];
                    boolean isBooked = bookLesson(lesson, currentUser, day, week);
                    if (isBooked && currentBooking!=null){
                        bookings.remove(currentBooking);
                    }

                    if (isBooked){
                        System.out.println(lesson.getName()+" ["+lesson.getType()+"] is Booked on "+day+" ("+week+") @Rs."+ lesson.getPrice());
                        System.out.println("Do You want to Attend This lesson ?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice = getChoice();
                        if (choice==1)
                            bookings.get(bookings.size()-1).attend();
                        else if(choice!=2){
                            System.out.println("Invalid choice...!\n");
                        }
                    }
                }else{
                    System.out.println("Invalid Day...!\n");
                }
            }else{
                System.out.println("Invalid Week...!\n");
            }
        } else {
            System.out.println("Invalid Type...!");
        }
    }


    static void printReport(){
        System.out.println("────────────────────────[ 4 Week Report ]────────────────────────");

//        bookings.sort(Comparator.comparing(o -> o.bookingWeek.toString()));

        int totalEarning=0;
        System.out.println("Week-1");
        for (DailyBooking b : bookings) {
            if (b.getBookingWeek() == Week1 && b.isAttended()) {
                System.out.println(b.getReport());
                totalEarning+=b.getLesson().getPrice();
            }
        }
        System.out.println("Week-2");
        for (DailyBooking b : bookings) {
            if (b.getBookingWeek() == Week2 && b.isAttended()) {
                System.out.println(b.getReport());
                totalEarning+=b.getLesson().getPrice();
            }
        }
        System.out.println("Week-3");
        for (DailyBooking b : bookings) {
            if (b.getBookingWeek() == Week3 && b.isAttended()) {
                System.out.println(b.getReport());
                totalEarning+=b.getLesson().getPrice();
            }
        }
        System.out.println("Week-4");
        for (DailyBooking b : bookings) {
            if (b.getBookingWeek() == Week4 && b.isAttended()) {
                System.out.println(b.getReport());
                totalEarning+=b.getLesson().getPrice();
            }
        }
        System.out.println("\nTotal Income of 4 Weeks = Rs."+totalEarning+'\n');

    }

    static boolean canBookLesson(FitnessLesson lesson, BookingDay day, BookingWeek week){
        int bookingCount = 0;
        for (DailyBooking b : bookings){
            if(b.getLesson().equals(lesson)){
                bookingCount++;
            }
            if (bookingCount == Constants.maxCustomersPerLesson) {
                System.out.println("Lesson is Full");
                return false;
            }
        }
        bookingCount=0;


        for (DailyBooking b : bookings){
            if(b.getBookingWeek() == week && day == b.getBookingDay() && b.getLesson().equals(lesson)){
                bookingCount++;
            }else if (bookingCount == Constants.maxLessonsPerDay) {
                System.out.println("Booking for "+lesson.getName()+" is Full on " + day + " - "+week);
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
            if(b.getCustomer().equals(customer) && b.getLesson().equals(lesson) && day == b.getBookingDay() && week == b.getBookingWeek())
                return true;
        }
        return false;
    }

    static void viewUserBookings(Customer customer){
        userBookings.clear();
        for (DailyBooking b:bookings) {
            if(b.getCustomer().getPhone().equals(customer.getPhone())){
                userBookings.add(b);
            }
        }
    }



    private static void initData(){
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Lesson-1", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Lesson-2", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Lesson-3", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.BODY_SCULPT,"Lesson-4", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.YOGA,"Lesson-5", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.SPIN,"Lesson-6", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.ZUMBA,"Lesson-7", Arrays.asList(Saturday, Sunday)));
        lessons.add(new FitnessLesson(FitnessType.AQUACISE,"Lesson-8", Arrays.asList(Saturday, Sunday)));

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
        isBooked = bookLesson(lessons.get(7), customers.get(3), Sunday, Week3);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(5), customers.get(4), Sunday, Week4);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(6), customers.get(5), Sunday, Week2);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(4), customers.get(6), Sunday, Week3);
        if(isBooked) bookings.get(bookings.size()-1).attend();
        isBooked = bookLesson(lessons.get(5), customers.get(1), Sunday, Week4);
        if(isBooked) bookings.get(bookings.size()-1).attend();



    }
}
