package application;

import models.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FitnessClubTest {



    @Test
    void testLogin() {
        FitnessClub club= new FitnessClub();
        club.customers.add(new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1));
        assertFalse(club.login("03023634694"));
        assertTrue(club.login("03000838330"));
    }



    @Test
    void testAttendALesson() {

        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        DailyBooking dailyBooking = new DailyBooking(BookingDay.Saturday, BookingWeek.Week1, lesson, customer);

        dailyBooking.attend();

        assertTrue(dailyBooking.isAttended());
    }

    @Test
    void testAttendALesson2() {

        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        DailyBooking dailyBooking = new DailyBooking(BookingDay.Saturday, BookingWeek.Week1, lesson, customer);

        assertFalse(dailyBooking.isAttended());
    }

    @Test
    void testRateLesson() {
        FitnessClub club= new FitnessClub();
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        assertEquals("No Reviews", club.ratings.get(lesson.getType()).toString());

        club.addRating(lesson, 4);
        club.addRating(lesson, 5);
        assertEquals("4.5 (2)", club.ratings.get(lesson.getType()).toString());

    }


    @Test
    void testShowAvailableLessons() {

        new FitnessClub().showAvailableLessons(BookingDay.Saturday);
    }



    @Test
    void testCanBookLesson() {

        assertTrue(new FitnessClub().canBookLesson(new FitnessLesson(FitnessType.SPIN, "Name", new ArrayList<>()), BookingDay.Saturday,
                BookingWeek.Week1));
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testCanBookLesson2() {

        new FitnessClub().canBookLesson(null, BookingDay.Saturday, BookingWeek.Week1);
    }


    @Test
    void testBookLesson() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03146326346", 3, 1);

        assertTrue(new FitnessClub().bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
    }

    @Test
    void testBookLesson2() {
        FitnessClub club= new FitnessClub();

        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        assertTrue(club.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
        assertFalse(club.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
    }




    @Test
    void testIsAlreadyLessonBooked() {
        FitnessClub club= new FitnessClub();

        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        club.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1);

        assertTrue(club.isAlreadyLessonBooked(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
    }

    @Test
    void testIsAlreadyLessonBooked2() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.YOGA, "Name", new ArrayList<>());

        assertFalse(new FitnessClub().isAlreadyLessonBooked(lesson, new Customer("Name", "42 Main St", "4105551212", 3, 1),
                BookingDay.Saturday, BookingWeek.Week1));
    }

}