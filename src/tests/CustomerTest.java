package tests;

import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void Setup(){
        customer = new Customer(true);
    }

    @Test
    public void canCustomerHaveLoyaltyCard(){
        assertEquals(true, customer.hasLoyaltyCard());
    }


}
