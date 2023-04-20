package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FitnessTypeTest {

    @Test
    void testValueOf() {
        assertEquals(FitnessType.valueOf("YOGA"), FitnessType.YOGA);
    }

    @Test
    void testPrice() {
        assertEquals(2500, FitnessType.YOGA.price);
    }


    @Test
    void testValues() {
        FitnessType[] actualValuesResult = FitnessType.values();
        assertEquals(6, actualValuesResult.length);
        assertEquals(FitnessType.SPIN, actualValuesResult[0]);
        assertEquals(FitnessType.YOGA, actualValuesResult[1]);

    }
}

