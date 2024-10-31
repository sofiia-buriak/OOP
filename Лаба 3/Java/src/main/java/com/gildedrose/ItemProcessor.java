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
}
