package tests;

import models.Basket;
import models.CheckOut;
import models.Customer;
import models.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Created by user on 22/07/2017.
 */
public class CheckOutTest {

    CheckOut checkOut;
    Basket basket;
    Customer customer;
    Item steak = new Item("28 day fillet", 10.00f);
    Item glasses = new Item("set of 6 goblets", 22.00f);
    Item milk = new Item("four pints, whole milk", 2.25f);

    @Before
    public void Setup(){
        this.basket = new Basket();
        this.customer = new Customer(true);
        this.checkOut = new CheckOut(customer, basket);
    }

    @Test
    public void canGetSubTotalWithFreeOffer(){
        basket.addToBasket(steak);
        basket.addToBasket(steak);
        assertEquals(10.00, checkOut.subtotalIncOffers(), 0.01);
    }

    @Test
    public void canGetMultipleFreeOfferAndDiscounts_Under20(){
        basket.addToBasket(milk);
        basket.addToBasket(milk);
        basket.addToBasket(milk);
        basket.addToBasket(milk);
        assertEquals(4.50, checkOut.subtotalIncOffers(), 0.01);
    }

    @Test
    public void canGetMultipleFreeOfferAndDiscounts_Over20(){
        basket.addToBasket(glasses);
        basket.addToBasket(glasses);
        basket.addToBasket(glasses);
        basket.addToBasket(glasses);
        assertEquals(39.60, checkOut.subtotalIncOffers(), 0.01);
    }

}
