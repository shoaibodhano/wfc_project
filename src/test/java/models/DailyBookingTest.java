package models;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyBookingTest {
    @Test
    void testConstructor() {
        FitnessLesson fitnessLesson = new FitnessLesson(FitnessType.SPIN, "Name", new ArrayList<>());

        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        DailyBooking actualDailyBooking = new DailyBooking(BookingDay.Saturday, BookingWeek.Week1, fitnessLesson, customer);

        assertEquals(BookingDay.Saturday, actualDailyBooking.getBookingDay());
        assertEquals(BookingWeek.Week1, actualDailyBooking.getBookingWeek());
        assertSame(customer, actualDailyBooking.getCustomer());
        assertSame(fitnessLesson, actualDailyBooking.getLesson());
        assertFalse(actualDailyBooking.isAttended());
    }

    @Test
    void testToString() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-2", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        assertEquals("Lesson-2 [SPIN] on (Saturday/Week1) - Not Attended",
                (new DailyBooking(BookingDay.Saturday, BookingWeek.Week1, lesson, customer)).toString());
    }


    @Test
    void testGetReport() {
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        assertEquals("Shoaib - Lesson-1 (SPIN) @Rs.2000",
                (new DailyBooking(BookingDay.Saturday, BookingWeek.Week1, lesson, customer)).getReport());

    }

    @Test
    void testAttendBooking(){
        FitnessLesson lesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>());
        Customer customer = new Customer("Shoaib", "Jamshoro", "03000838330", 3, 1);

        DailyBooking dailyBooking = new DailyBooking(BookingDay.Saturday, BookingWeek.Week1, lesson, customer);

        dailyBooking.attend();

        assertTrue(dailyBooking.isAttended());

    }


}

