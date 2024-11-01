package com.gildedrose;

public class Item {
    private final ItemName name;
    private final ItemProperties properties;

    public Item(ItemName name, ItemProperties properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name.getValue();
    }

    public ItemProperties getProperties() {
        return properties;
    }
}