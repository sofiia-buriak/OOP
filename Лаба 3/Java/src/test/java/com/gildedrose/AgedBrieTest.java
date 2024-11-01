package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    public void testUpdateQuality() {
        Item item = new Item(new ItemName("Aged Brie"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20))));
        AgedBrie agedBrie = new AgedBrie(item);
        agedBrie.updateQuality(new QualityUpdater(item.retrieveProperties()));

        assertEquals(21, item.retrieveProperties().retrieveQuality().obtainIntValue());
    }

    @Test
    public void testProcessExpired() {
        Item item = new Item(new ItemName("Aged Brie"), new ItemProperties(new SellIn(new IntegerValue(0)), new ItemQuality(new IntegerValue(20))));
        AgedBrie agedBrie = new AgedBrie(item);
        agedBrie.processExpired(new QualityUpdater(item.retrieveProperties()));

        assertEquals(21, item.retrieveProperties().retrieveQuality().obtainIntValue());
    }
}
