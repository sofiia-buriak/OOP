package com.gildedrose;

import org.junit.jupiter.api.Test;

public class SulfurasTest {

    @Test
    public void testUpdateQuality() {
        Item item = new Item(new ItemName("Sulfuras, Hand of Ragnaros"), new ItemProperties(new SellIn(new IntegerValue(0)), new ItemQuality(new IntegerValue(80))));
        Sulfuras sulfuras = new Sulfuras(item);
        sulfuras.updateQuality(new QualityUpdater(item.retrieveProperties()));
    }

    @Test
    public void testUpdateExpiration() {
        Item item = new Item(new ItemName("Sulfuras, Hand of Ragnaros"), new ItemProperties(new SellIn(new IntegerValue(0)), new ItemQuality(new IntegerValue(80))));
        Sulfuras sulfuras = new Sulfuras(item);
        sulfuras.updateExpiration();
    }
}
