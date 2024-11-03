package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {

    @Test
    public void testUpdateQuality() {
        Item item = new Item(new ItemName("Backstage passes to a TAFKAL80ETC concert"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20))));
        BackstagePasses backstagePasses = new BackstagePasses(item);
        backstagePasses.updateQuality(new QualityUpdater(backstagePasses.fetchItemProperties()));

        assertEquals(22, backstagePasses.fetchItemProperties().retrieveQuality().obtainIntValue());
    }

    @Test
    public void testProcessExpired() {
        Item item = new Item(new ItemName("Backstage passes to a TAFKAL80ETC concert"), new ItemProperties(new SellIn(new IntegerValue(0)), new ItemQuality(new IntegerValue(20))));
        BackstagePasses backstagePasses = new BackstagePasses(item);
        backstagePasses.processExpired(new QualityUpdater(backstagePasses.fetchItemProperties()));

        assertEquals(0, backstagePasses.fetchItemProperties().retrieveQuality().obtainIntValue());
    }
}
