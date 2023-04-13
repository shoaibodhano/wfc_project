package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerTest {

    @Test
    void testConstructor() {
        Customer c = new Customer("Amjad", "Hyderabad", "03000838330", 68,27);
        assertNotNull(c);
        assertEquals(68, c.weight);
        assertEquals(27, c.age);
    }

}

