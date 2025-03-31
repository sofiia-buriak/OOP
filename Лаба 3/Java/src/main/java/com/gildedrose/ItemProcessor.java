package com.gildedrose;

public class ItemProcessor {
    private final Item[] items;

    public ItemProcessor(Item[] items) {
        this.items = items;
    }

    public void processAll() {
        for (Item item : items) {
            processItem(item);
        }
    }

    private void processItem(Item item) {
        InventoryItem inventoryItem = createInventoryItem(item);
        inventoryItem.dailyUpdate();
    }

    private InventoryItem createInventoryItem(Item item) {
        String itemName = item.fetchName();
        return selectInventoryItem(itemName, item);
    }

    private InventoryItem selectInventoryItem(String itemName, Item item) {
        if (isEqual(itemName, AgedBrie.NAME)) return new AgedBrie(item);
        if (isEqual(itemName, BackstagePasses.NAME)) return new BackstagePasses(item);
        if (isEqual(itemName, Sulfuras.NAME)) return new Sulfuras(item);
        return new InventoryItem(item);
    }

    private boolean isEqual(String itemName, String targetName) {
        return itemName.equals(targetName);
    }
}