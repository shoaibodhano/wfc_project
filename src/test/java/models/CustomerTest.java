package models;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer("Shoaib", "Jamshoro", "03000838330", 67, 26);

        assertEquals("Jamshoro", actualCustomer.getAddress());
        assertEquals(26, actualCustomer.getAge());
        assertEquals("Shoaib", actualCustomer.getName());
        assertEquals("03000838330", actualCustomer.getPhone());
        assertEquals(67, actualCustomer.getWeight());
    }



    @Test
    void testName() {
        Customer customer = new Customer(null, null, null, 0, 0);
        customer.setName("Shoaib");
        assertEquals("Shoaib",customer.getName());
    }

    @Test
    void testAddress() {
        Customer customer = new Customer(null, null, null, 0, 0);
        customer.setAddress("Jamshoro");
        assertEquals("Jamshoro",customer.getAddress());
    }

    @Test
    void testAge() {
        Customer customer = new Customer(null, null, null, 0, 0);
        customer.setAge(67);
        assertEquals(67,customer.getAge());
    }


    @Test
    void testPhone() {
        Customer customer = new Customer(null, null, null, 0, 0);
        customer.setPhone("03000838330");
        assertEquals("03000838330",customer.getPhone());
    }

    @Test
    void testWeight() {
        Customer customer = new Customer(null, null, null, 0, 0);
        customer.setWeight(65);
        assertEquals(65,customer.getWeight());
    }

}

