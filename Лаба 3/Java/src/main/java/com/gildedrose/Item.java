package com.gildedrose;

public class Item {
    private final ItemName name;
    private final ItemProperties properties;

    public Item(ItemName name, ItemProperties properties) {
        this.name = name;
        this.properties = properties;
    }

    public ItemName getName() {
        return name;
    }

    public ItemProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return name.getValue() + ", " +
                properties.getSellIn().getValue() + ", " +
                properties.getQuality().getValue();
    }
}