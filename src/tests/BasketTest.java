package tests;

import models.Basket;
import models.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by user on 22/07/2017.
 */
public class BasketTest {

    Basket basket;
    Item bread = new Item("Granary", 1.50f);
    Item milk = new Item("four pints, whole milk", 2.25f);
    Item wine = new Item("bottle, red", 6.99f);
    Item steak = new Item("28 day fillet", 10.00f);
    Item glasses = new Item("set of 6 goblets", 22.00f);

    @Before
    public void Setup(){
        basket = new Basket();
    }

    @Test
    public void canGetBasketSize(){
        assertEquals(0, basket.getBasketSize());
    }

    @Test
    public void canAddToBasket(){
        basket.addToBasket(milk);
        assertEquals(1, basket.getBasketSize());
    }

    @Test
    public void canEmptyBasket(){
        basket.addToBasket(bread);
        basket.addToBasket(wine);
        assertEquals(2, basket.getBasketSize());
        basket.emptyBasket();
        assertEquals(0, basket.getBasketSize());
    }

    @Test
    public void canAddDuplicateItems(){
        basket.addToBasket(wine);
        basket.addToBasket(wine);
        assertEquals(2, basket.getBasketSize());
    }

    @Test
    public void canRemoveItem(){
        basket.addToBasket(bread);
        basket.addToBasket(wine);
        assertEquals(2, basket.getBasketSize());
        basket.removeBasketItem(bread);
        assertEquals(1, basket.getBasketSize());
    }

    @Test
    public void testEmptyBasket(){
        assertEquals(0, basket.getBasketTotal(), 0.01);
    }

    @Test
    public void testBasketWithMultipleItems(){
        basket.addToBasket(steak);
        basket.addToBasket(milk);
        basket.addToBasket(glasses);
        assertEquals(34.25, basket.getBasketTotal(), 0.01);
    }

}
