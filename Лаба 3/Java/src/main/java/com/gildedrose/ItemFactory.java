package com.gildedrose;

public class ItemFactory {
    private final ItemName name;

    public ItemFactory(String nameValue) {
        this.name = new ItemName(nameValue);
    }

    public Item createItem(int sellInValue, int qualityValue) {
        IntegerValue sellInInteger = new IntegerValue(sellInValue);
        IntegerValue qualityInteger = new IntegerValue(qualityValue);
        SellIn sellIn = new SellIn(sellInInteger);
        ItemQuality quality = new ItemQuality(qualityInteger);
        ItemProperties properties = new ItemProperties(sellIn, quality);
        return new Item(name, properties);
    }
}