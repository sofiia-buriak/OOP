package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemQualityTest {

    @Test
    public void testIncrease() {
        ItemQuality quality = new ItemQuality(new IntegerValue(20));
        quality.increase();
        assertEquals(21, quality.obtainIntValue());
    }

    @Test
    public void testDecrease() {
        ItemQuality quality = new ItemQuality(new IntegerValue(20));
        quality.decrease();
        assertEquals(19, quality.obtainIntValue());
    }

    @Test
    public void testAssignValue() {
        ItemQuality quality = new ItemQuality(new IntegerValue(20));
        quality.assignValue(new IntegerValue(30));
        assertEquals(30, quality.obtainIntValue());
    }
}
