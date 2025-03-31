package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemFactoryTest {

    @Test
    public void testCreateItem() {
        ItemFactory factory = new ItemFactory("Test Item");
        Item item = factory.createItem(10, 20);

        assertNotNull(item);
    }
}
