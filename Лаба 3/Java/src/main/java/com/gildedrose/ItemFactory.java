package com.gildedrose;

public class ItemFactory {
    private final ItemName name;

    public ItemFactory(String name) {
        this.name = new ItemName(name);
    }

    public Item createItem(int sellIn, int quality) {
        SellIn sellInObj = new SellIn(sellIn);
        ItemQuality qualityObj = new ItemQuality(quality);
        ItemProperties properties = new ItemProperties(sellInObj, qualityObj);
        return new Item(name, properties);
    }
}