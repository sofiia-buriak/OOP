package com.gildedrose;

public class GildedRose {
    private final ItemProcessor processor;

    public GildedRose(Item[] items) {
        this.processor = new ItemProcessor(items);
    }
}