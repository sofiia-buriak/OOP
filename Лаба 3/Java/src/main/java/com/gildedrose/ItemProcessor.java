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
        String itemName = item.getName();
        boolean isAgedBrie = isAgedBrie(itemName);
        if (isAgedBrie) {
            return new AgedBrie(item);
        }
        boolean isBackstagePasses = isBackstagePasses(itemName);
        if (isBackstagePasses) {
            return new BackstagePasses(item);
        }
        boolean isSulfuras = isSulfuras(itemName);
        if (isSulfuras) {
            return new Sulfuras(item);
        }
        return new InventoryItem(item);
    }
    private boolean isAgedBrie(String itemName) {
        return isEqual(itemName, AgedBrie.NAME);
    }
    private boolean isBackstagePasses(String itemName) {
        return isEqual(itemName, BackstagePasses.NAME);
    }
    private boolean isSulfuras(String itemName) {
        return isEqual(itemName, Sulfuras.NAME);
    }
    private boolean isEqual(String itemName, String targetName) {
        return itemName.equals(targetName);
    }
}
