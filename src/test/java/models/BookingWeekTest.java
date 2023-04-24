package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BookingWeekTest {

    @Test
    void testValueOf() {
        assertEquals(BookingWeek.valueOf("Week1"), BookingWeek.Week1);
    }


    @Test
    void testValues() {
        BookingWeek[] actualValuesResult = BookingWeek.values();
        assertEquals(8, actualValuesResult.length);
        assertEquals(BookingWeek.Week1, actualValuesResult[0]);
        assertEquals(BookingWeek.Week2, actualValuesResult[1]);
        assertEquals(BookingWeek.Week3, actualValuesResult[2]);
        assertEquals(BookingWeek.Week4, actualValuesResult[3]);
    }
}

