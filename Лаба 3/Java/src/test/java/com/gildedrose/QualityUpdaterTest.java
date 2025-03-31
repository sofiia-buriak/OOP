package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityUpdaterTest {

    @Test
    public void testDecrease() {
        ItemProperties properties = new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20)));
        QualityUpdater updater = new QualityUpdater(properties);
        updater.decrease();
        assertEquals(19, properties.retrieveQuality().obtainIntValue());
    }

    @Test
    public void testIncrease() {
        ItemProperties properties = new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20)));
        QualityUpdater updater = new QualityUpdater(properties);
        updater.increase();
        assertEquals(21, properties.retrieveQuality().obtainIntValue());
    }
}
