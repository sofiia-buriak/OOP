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
        createInventoryItem(item).dailyUpdate();
    }

    private InventoryItem createInventoryItem(Item item) {
        if (item.getName().equals(AgedBrie.NAME)) {
            return new AgedBrie(item);
        }
        if (item.getName().equals(BackstagePasses.NAME)) {
            return new BackstagePasses(item);
        }
        if (item.getName().equals(Sulfuras.NAME)) {
            return new Sulfuras(item);
        }
        return new InventoryItem(item);
    }
}
