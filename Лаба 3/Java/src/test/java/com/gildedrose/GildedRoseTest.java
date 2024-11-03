package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void testConstructor() {
        Item[] items = new Item[] {};
        GildedRose gildedRose = new GildedRose(items);

        assertEquals(0, items.length);
    }
}

