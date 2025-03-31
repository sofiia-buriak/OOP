package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryItemTest {

    @Test
    public void testDailyUpdate() {
        Item item = new Item(new ItemName("Test Item"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20))));
        InventoryItem inventoryItem = new InventoryItem(item);
        inventoryItem.dailyUpdate();

        assertEquals(19, inventoryItem.fetchItemProperties().retrieveQuality().obtainIntValue());

        assertEquals(9, inventoryItem.fetchItemProperties().retrieveSellIn().obtainDays());
    }

    @Test
    public void testUpdateQuality() {
        Item item = new Item(new ItemName("Test Item"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20))));
        InventoryItem inventoryItem = new InventoryItem(item);
        QualityUpdater updater = new QualityUpdater(inventoryItem.fetchItemProperties());

        inventoryItem.updateQuality(updater);

        assertEquals(19, inventoryItem.fetchItemProperties().retrieveQuality().obtainIntValue());
    }

    @Test
    public void testUpdateExpiration() {
        Item item = new Item(new ItemName("Test Item"), new ItemProperties(new SellIn(new IntegerValue(10)), new ItemQuality(new IntegerValue(20))));
        InventoryItem inventoryItem = new InventoryItem(item);

        inventoryItem.updateExpiration();

        assertEquals(9, inventoryItem.fetchItemProperties().retrieveSellIn().obtainDays());
    }

    @Test
    public void testIsExpired() {
        Item item = new Item(new ItemName("Test Item"), new ItemProperties(new SellIn(new IntegerValue(-1)), new ItemQuality(new IntegerValue(20))));
        InventoryItem inventoryItem = new InventoryItem(item);

        assertTrue(inventoryItem.isExpired());
    }

    @Test
    public void testProcessExpired() {
        Item item = new Item(new ItemName("Test Item"), new ItemProperties(new SellIn(new IntegerValue(0)), new ItemQuality(new IntegerValue(20))));
        InventoryItem inventoryItem = new InventoryItem(item);
        QualityUpdater updater = new QualityUpdater(inventoryItem.fetchItemProperties());

        inventoryItem.processExpired(updater);

        assertEquals(19, inventoryItem.fetchItemProperties().retrieveQuality().obtainIntValue());
    }
}
