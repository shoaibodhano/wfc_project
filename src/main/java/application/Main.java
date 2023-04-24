package application;

import models.*;

import java.util.Collections;
import java.util.Scanner;

import static models.BookingDay.Saturday;
import static models.BookingDay.Sunday;
import static models.BookingWeek.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FitnessClub club = new FitnessClub();

        initData(club);

        int choice;

        while(true) {

            System.out.println("Select Your Choice:");

            System.out.println("1. Login");
            System.out.println("0. Exit");
            choice = club.getChoice();

            if (choice==1){
                System.out.println("Enter Your Phone Number to Login: ");
                String phone = sc.next();
                if (club.login(phone)){
                    club.start();
                }
            } else if (choice==0){
                System.exit(0);
            } else {
                System.out.println("Invalid Choice\n");
            }
        }

    }



    private static void initData(FitnessClub club){

        FitnessLesson lesson1 = new FitnessLesson(FitnessType.YOGA,"Lesson-1", Collections.singletonList(Saturday));
        FitnessLesson lesson2 = new FitnessLesson(FitnessType.YOGA,"Lesson-2", Collections.singletonList(Saturday));
        FitnessLesson lesson3 = new FitnessLesson(FitnessType.YOGA,"Lesson-3", Collections.singletonList(Saturday));
        FitnessLesson lesson4 = new FitnessLesson(FitnessType.YOGA,"Lesson-4", Collections.singletonList(Saturday));
        FitnessLesson lesson5 = new FitnessLesson(FitnessType.YOGA,"Lesson-5", Collections.singletonList(Saturday));
        FitnessLesson lesson6 = new FitnessLesson(FitnessType.YOGA,"Lesson-6", Collections.singletonList(Saturday));
        FitnessLesson lesson7 = new FitnessLesson(FitnessType.YOGA,"Lesson-7", Collections.singletonList(Saturday));
        FitnessLesson lesson8 = new FitnessLesson(FitnessType.YOGA,"Lesson-8", Collections.singletonList(Saturday));
        FitnessLesson lesson9 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-9", Collections.singletonList(Saturday));
        FitnessLesson lesson10 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-10", Collections.singletonList(Saturday));
        FitnessLesson lesson11 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-11", Collections.singletonList(Saturday));
        FitnessLesson lesson12 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-12", Collections.singletonList(Saturday));
        FitnessLesson lesson13 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-13", Collections.singletonList(Saturday));
        FitnessLesson lesson14 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-14", Collections.singletonList(Saturday));
        FitnessLesson lesson15 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-15", Collections.singletonList(Saturday));
        FitnessLesson lesson16 = new FitnessLesson(FitnessType.BOX_FIT,"Lesson-16", Collections.singletonList(Saturday));
        FitnessLesson lesson17 = new FitnessLesson(FitnessType.SPIN,"Lesson-17", Collections.singletonList(Sunday));
        FitnessLesson lesson18 = new FitnessLesson(FitnessType.SPIN,"Lesson-18", Collections.singletonList(Sunday));
        FitnessLesson lesson19 = new FitnessLesson(FitnessType.SPIN,"Lesson-19", Collections.singletonList(Sunday));
        FitnessLesson lesson20 = new FitnessLesson(FitnessType.SPIN,"Lesson-20", Collections.singletonList(Sunday));
        FitnessLesson lesson21 = new FitnessLesson(FitnessType.SPIN,"Lesson-21", Collections.singletonList(Sunday));
        FitnessLesson lesson22 = new FitnessLesson(FitnessType.SPIN,"Lesson-22", Collections.singletonList(Sunday));
        FitnessLesson lesson23 = new FitnessLesson(FitnessType.SPIN,"Lesson-23", Collections.singletonList(Sunday));
        FitnessLesson lesson24 = new FitnessLesson(FitnessType.SPIN,"Lesson-24", Collections.singletonList(Sunday));
        FitnessLesson lesson25 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-25", Collections.singletonList(Sunday));
        FitnessLesson lesson26 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-26", Collections.singletonList(Sunday));
        FitnessLesson lesson27 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-27", Collections.singletonList(Sunday));
        FitnessLesson lesson28 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-28", Collections.singletonList(Sunday));
        FitnessLesson lesson29 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-29", Collections.singletonList(Sunday));
        FitnessLesson lesson30 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-30", Collections.singletonList(Sunday));
        FitnessLesson lesson31 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-31", Collections.singletonList(Sunday));
        FitnessLesson lesson32 = new FitnessLesson(FitnessType.ZUMBA,"Lesson-32", Collections.singletonList(Sunday));


        Customer customer1 = new Customer("Shoaib", "Hyderabad", "1111111111", 71, 25);
        Customer customer2 = new Customer("Amjad", "Hyderabad", "2222222222", 68, 27);
        Customer customer3 = new Customer("Majid", "Hyderabad", "3333333333", 69, 26);
        Customer customer4 = new Customer("Bilal", "Hyderabad", "4444444444", 86, 32);
        Customer customer5 = new Customer("Faraz", "Bandhi", "5555555555", 79, 23);
        Customer customer6 = new Customer("Fahad", "Bandhi", "6666666666", 95, 35);
        Customer customer7 = new Customer("Aftab", "Kotri", "7777777777", 127, 29);
        Customer customer8 = new Customer("Rafi", "Jamshoro", "8888888888", 77, 26);
        Customer customer9 = new Customer("Shahbaz", "Jamshoro", "9999999999", 72, 28);
        Customer customer10 = new Customer("Zohaib", "Latifabad", "0000000000", 69, 24);


        club.addLesson(lesson1);
        club.addLesson(lesson2);
        club.addLesson(lesson3);
        club.addLesson(lesson4);
        club.addLesson(lesson5);
        club.addLesson(lesson6);
        club.addLesson(lesson7);
        club.addLesson(lesson8);
        club.addLesson(lesson9);
        club.addLesson(lesson10);
        club.addLesson(lesson11);
        club.addLesson(lesson12);
        club.addLesson(lesson13);
        club.addLesson(lesson14);
        club.addLesson(lesson15);
        club.addLesson(lesson16);
        club.addLesson(lesson17);
        club.addLesson(lesson18);
        club.addLesson(lesson19);
        club.addLesson(lesson20);
        club.addLesson(lesson21);
        club.addLesson(lesson22);
        club.addLesson(lesson23);
        club.addLesson(lesson24);
        club.addLesson(lesson25);
        club.addLesson(lesson26);
        club.addLesson(lesson27);
        club.addLesson(lesson28);
        club.addLesson(lesson29);
        club.addLesson(lesson30);
        club.addLesson(lesson31);
        club.addLesson(lesson32);


        club.addCustomer(customer1);
        club.addCustomer(customer2);
        club.addCustomer(customer3);
        club.addCustomer(customer4);
        club.addCustomer(customer5);
        club.addCustomer(customer6);
        club.addCustomer(customer7);
        club.addCustomer(customer8);
        club.addCustomer(customer9);
        club.addCustomer(customer10);


        //Bookings for Saturday
        if(club.bookLesson(lesson1, customer1, Saturday, Week1)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 5);
        }
        if(club.bookLesson(lesson1, customer2, Saturday, Week5)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 3);
        }
        if(club.bookLesson(lesson2, customer5, Saturday, Week6)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 4);
        }
        if(club.bookLesson(lesson3, customer6, Saturday, Week2)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 5);
        }
        if(club.bookLesson(lesson6, customer7, Saturday, Week3)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 4);
        }
        if(club.bookLesson(lesson5, customer8, Saturday, Week7)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 4);
        }
        if(club.bookLesson(lesson2, customer10, Saturday, Week8)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 3);
        }


        //Bookings for Sunday
        if(club.bookLesson(lesson4, customer1, Sunday, Week1)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 4);
        }
        if(club.bookLesson(lesson2, customer2, Sunday, Week8)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 5);
        }
        if(club.bookLesson(lesson4, customer3, Sunday, Week2)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 4);
        }
        if(club.bookLesson(lesson8, customer4, Sunday, Week3)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 3);
        }
        if(club.bookLesson(lesson6, customer5, Sunday, Week2)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 4);
        }
        if(club.bookLesson(lesson7, customer6, Sunday, Week6)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 3);
        }
        if(club.bookLesson(lesson5, customer7, Sunday, Week3)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 3);
        }
        if(club.bookLesson(lesson6, customer2, Sunday, Week4)) {
            club.getLastBooking().attend();
            club.addRating(club.getLastBooking().getLesson(), 5);
        }



    }


}
