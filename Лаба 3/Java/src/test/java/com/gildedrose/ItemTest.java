package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testFetchName() {
        Item item = new Item(new ItemName("Item"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20))));
        assertEquals("Item", item.fetchName());
    }

    @Test
    public void testRetrieveProperties() {
        ItemProperties properties = new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20)));
        Item item = new Item(new ItemName("Item"), properties);
        assertEquals(properties, item.retrieveProperties());
    }
}
