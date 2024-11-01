package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemNameTest {

    @Test
    public void testFetchValue() {
        ItemName name = new ItemName("Test Item");
        assertEquals("Test Item", name.fetchValue());
    }

    @Test
    public void testEquals() {
        ItemName name = new ItemName("Test Item");
        assertTrue(name.equals("Test Item"));
    }
}
