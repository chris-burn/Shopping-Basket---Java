package tests;

import models.Basket;
import models.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/07/2017.
 */
public class CustomerTest {

    Customer customer;
    Basket basket;

    @Before
    public void Setup(){
        customer = new Customer(true);
    }

    @Test
    public void canCustomerHaveLoyaltyCard(){
        assertEquals(true, customer.hasLoyaltyCard());
    }

//    @Test
//    public void canOwnBasket(){
//        assertEquals(basket, customer.setBasket());
//    }

}
