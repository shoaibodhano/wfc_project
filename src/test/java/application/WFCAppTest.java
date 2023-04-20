package application;

import models.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WFCAppTest {



    @Test
    void testLogin() {
        WFCApp.customers.add(new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1));
        assertFalse(WFCApp.login("03023634694"));
        assertTrue(WFCApp.login("03000838330"));
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
        // TODO: This test is incomplete.

        WFCApp.rateLesson(new FitnessLesson(FitnessType.SPIN, "Name", new ArrayList<>()));
    }


    @Test
    void testShowAvailableLessons() {

        WFCApp.showAvailableLessons(BookingDay.Saturday);
    }



    @Test
    void testCanBookLesson() {

        assertTrue(WFCApp.canBookLesson(new FitnessLesson(FitnessType.SPIN, "Name", new ArrayList<>()), BookingDay.Saturday,
                BookingWeek.Week1));
    }

    @Test
    @Disabled("TODO: This test is incomplete")
    void testCanBookLesson2() {

        WFCApp.canBookLesson(null, BookingDay.Saturday, BookingWeek.Week1);
    }


    @Test
    void testBookLesson() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03146326346", 3, 1);

        assertTrue(WFCApp.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
    }

    @Test
    void testBookLesson2() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        assertTrue(WFCApp.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
        assertFalse(WFCApp.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
    }




    @Test
    void testIsAlreadyLessonBooked() {

        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        WFCApp.bookLesson(lesson, customer, BookingDay.Saturday, BookingWeek.Week1);

        assertTrue(WFCApp.isAlreadyLessonBooked(lesson, customer, BookingDay.Saturday, BookingWeek.Week1));
    }

    @Test
    void testIsAlreadyLessonBooked2() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.YOGA, "Name", new ArrayList<>());

        assertFalse(WFCApp.isAlreadyLessonBooked(lesson, new Customer("Name", "42 Main St", "4105551212", 3, 1),
                BookingDay.Saturday, BookingWeek.Week1));
    }

}