package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SellInTest {

    @Test
    public void testObtainDays() {
        SellIn sellIn = new SellIn(new IntegerValue(10));
        assertEquals(10, sellIn.obtainDays());
    }

    @Test
    public void testDecrease() {
        SellIn sellIn = new SellIn(new IntegerValue(10));
        sellIn.decrease();
        assertEquals(9, sellIn.obtainDays());
    }

    @Test
    public void testIsExpired() {
        SellIn sellIn = new SellIn(new IntegerValue(-1));
        assertTrue(sellIn.isExpired());
    }
}
