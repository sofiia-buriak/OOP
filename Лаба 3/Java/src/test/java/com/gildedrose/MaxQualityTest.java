package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxQualityTest {

    @Test
    public void testIsLessThan() {
        MaxQuality maxQuality = new MaxQuality();
        assertTrue(maxQuality.isLessThan(new IntegerValue(60)));
    }
}
