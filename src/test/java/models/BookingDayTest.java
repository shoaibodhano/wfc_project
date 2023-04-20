package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BookingDayTest {

    @Test
    void testValueOf() {

        assertEquals(BookingDay.valueOf("Saturday"), BookingDay.Saturday);
    }

    @Test
    void testValues() {
        BookingDay[] actualValuesResult = BookingDay.values();
        assertEquals(2, actualValuesResult.length);
        assertEquals(BookingDay.Saturday, actualValuesResult[0]);
        assertEquals(BookingDay.Sunday, actualValuesResult[1]);
    }

}

