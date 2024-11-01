package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemPropertiesTest {
    @Test
    public void testRetrieveSellIn() {
        SellIn sellIn = new SellIn(new IntegerValue(10));
        ItemProperties properties = new ItemProperties(sellIn, new ItemQuality(new IntegerValue(20)));
        assertEquals(sellIn, properties.retrieveSellIn());
    }

    @Test
    public void testRetrieveQuality() {
        ItemQuality quality = new ItemQuality(new IntegerValue(20));
        ItemProperties properties = new ItemProperties(new SellIn(new IntegerValue(10)), quality);
        assertEquals(quality, properties.retrieveQuality());
    }
}
