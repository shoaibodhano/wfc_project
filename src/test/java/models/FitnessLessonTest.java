package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class FitnessLessonTest {
    @Test
    void testConstructor() {
        ArrayList<BookingDay> bookingDayList = new ArrayList<>();
        FitnessLesson actualFitnessLesson = new FitnessLesson(FitnessType.SPIN, "Lesson-1", bookingDayList);

        assertSame(bookingDayList, actualFitnessLesson.getDaysOpen());
        assertEquals("Lesson-1", actualFitnessLesson.getName());
        assertEquals(FitnessType.SPIN, actualFitnessLesson.getType());
    }

    @Test
    void testGetPrice() {
        assertEquals(2000, (new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>())).getPrice());
    }

    @Test
    void testIsOpenOn() {
        assertFalse((new FitnessLesson(FitnessType.SPIN, "Lesson-1", new ArrayList<>())).isOpenOn(BookingDay.Saturday));
        assertFalse((new FitnessLesson(FitnessType.SPIN, "Name", new ArrayList<>())).isOpenOn(BookingDay.Sunday));
    }




}

