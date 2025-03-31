package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MaxQualityTest {

    @Test
    public void testIsLessThan() {
        MaxQuality maxQuality = new MaxQuality();
        assertTrue(maxQuality.isLessThan(new IntegerValue(40)));
    }

    @Test
    public void testIsNotLessThan() {
        MaxQuality maxQuality = new MaxQuality();
        assertFalse(maxQuality.isLessThan(new IntegerValue(60)));
    }
}