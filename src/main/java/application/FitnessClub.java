package application;

import models.*;
import utils.Constants;

import java.util.*;

import static models.BookingDay.*;

public class FitnessClub {

    ArrayList<DailyBooking> bookings = new ArrayList<>();
    ArrayList<DailyBooking> userBookings = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    Customer currentUser;

    ArrayList<FitnessLesson> lessons = new ArrayList<>();
    ArrayList<FitnessLesson> filteredLessons = new ArrayList<>();

    Map<FitnessType, Rating> ratings = new HashMap<>();

    public FitnessClub(){
        for (FitnessType fitnessType : FitnessType.values()) {
            ratings.put(fitnessType, new Rating());
        }
    }

    public int getChoice(){
        try {
            return new Scanner(System.in).nextInt();
        }catch (Exception e){
            return  -1;
        }
    }


    public boolean login(String phone){
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {
                currentUser = c;
                return true;
            }
        }
        return false;
    }



    public void start(){

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
    void cancelABooking(){
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

    void changeABooking(){
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
    void attendALesson(){
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

    void rateLesson(FitnessLesson l){
        System.out.println("How satisfied You with "+l.getType());

        System.out.println("1. Very Dissatisfied");
        System.out.println("2. Dissatisfied");
        System.out.println("3. OK");
        System.out.println("4. Satisfied");
        System.out.println("5. Very Satisfied");
        System.out.println("0. I will do it later");

        int rate =  getChoice();
        if(rate > 0 && rate <6) {
            ratings.get(l.getType()).addCustomerRating(rate);
            System.out.println("Thank you for Your Feedback (:\n");
        }
    }

    // Done
    void showAvailableLessons(BookingDay day){
        filteredLessons.clear();
        for (FitnessLesson l : lessons) {
             if (l.isOpenOn(day)) {
                filteredLessons.add(l);
                System.out.println(filteredLessons.size()+". "+l.toString().replaceAll("\n","\t"));
            }
        }
    }

    // Done
    void showAvailableLessons(FitnessType fitnessType){
        filteredLessons.clear();
        for (FitnessLesson l : lessons) {
            if (l.getType() == fitnessType) {
                filteredLessons.add(l);
                System.out.println(filteredLessons.size()+". "+l.toString().replaceAll("\n","\t"));
            }
        }
    }

    void selectLessonToBook(DailyBooking currentBooking){
        System.out.println("\nSelect a Lesson to Book\n");
        int choice = getChoice();
        if(choice > 0 && choice <= filteredLessons.size()) {
            FitnessLesson lesson = filteredLessons.get(choice-1);
            System.out.println("Select Week:");

            for(int i = 0; i<BookingWeek.values().length ; i++) {
                System.out.println((i+1)+". Week-" + (i + 1));
            }
            choice = getChoice();
            if (choice<=(BookingWeek.values().length) && choice>=1){
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
                        if (choice==1) {
                            bookings.get(bookings.size() - 1).attend();
                            rateLesson(lesson);
                        } else if (choice!=2){
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

    void printReport(){
        int totalWeeks = BookingWeek.values().length;

        System.out.println("────────────────────────[ " + totalWeeks + " Week Report ]────────────────────────");

        int totalEarning=0;

        for(int i = 0; i<totalWeeks ; i++) {
            System.out.println("Week-"+(i+1));
            for (DailyBooking b : bookings) {
                if (b.getBookingWeek() == BookingWeek.values()[i] && b.isAttended()) {
                    System.out.println(b.getReport());
                    totalEarning += b.getLesson().getPrice();
                }
            }
        }

        System.out.println("\nTotal Income of " + totalWeeks + " Weeks = Rs."+totalEarning+'\n');

    }

    boolean canBookLesson(FitnessLesson lesson, BookingDay day, BookingWeek week){
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

    boolean bookLesson(FitnessLesson lesson, Customer customer, BookingDay day, BookingWeek week){
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

    boolean isAlreadyLessonBooked(FitnessLesson lesson, Customer customer, BookingDay day, BookingWeek week){
        for (DailyBooking b : bookings){
            if(b.getCustomer().equals(customer) && b.getLesson().equals(lesson) && day == b.getBookingDay() && week == b.getBookingWeek())
                return true;
        }
        return false;
    }

    void viewUserBookings(Customer customer){
        userBookings.clear();
        for (DailyBooking b:bookings) {
            if(b.getCustomer().getPhone().equals(customer.getPhone())){
                userBookings.add(b);
            }
        }
    }


    void addLesson(FitnessLesson lesson){
        lessons.add(lesson);
    }

    void addCustomer(Customer customer){
        customers.add(customer);
    }


    public DailyBooking getLastBooking(){
        if (bookings.size() == 0){
            return null;
        }
        return bookings.get(bookings.size()-1);
    }

    void addRating(FitnessLesson lesson, int rating){
        ratings.get(lesson.getType()).addCustomerRating(rating);
    }

}
