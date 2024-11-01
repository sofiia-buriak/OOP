package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemProcessorTest {

    @Test
    public void testProcessAll() {
        Item[] items = new Item[] { new Item(new ItemName("Aged Brie"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20)))) };
        ItemProcessor processor = new ItemProcessor(items);
        processor.processAll();

        assertTrue(items[0].retrieveProperties().retrieveSellIn().obtainDays() < 10);
    }
}