package tests;

import models.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/07/2017.
 */
public class ItemTest {

    Item item;

    @Before
    public void Setup(){
        item = new Item("set of 6 goblets", 20.99f);
    }

    @Test
    public void testItemHasDescription(){
        assertEquals("set of 6 goblets", item.getDescription());
    }

    @Test
    public void testItemHasPrice(){
        assertEquals(20.99f, item.getPrice(), 0.01);
    }

    @Test
    public void testCanChangeDescription(){
        item.setDescription("bag of nails");
        assertEquals("bag of nails", item.getDescription());
    }

    @Test
    public void testCanSetPrice() {
        item.setPrice(6.10f);
        assertEquals(6.10f, item.getPrice(), 0.01);
    }
}
