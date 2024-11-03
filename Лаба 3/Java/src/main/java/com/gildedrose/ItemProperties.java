package com.gildedrose;

public class ItemProperties {
    private final SellIn sellIn;
    private final ItemQuality quality;

    public ItemProperties(SellIn sellIn, ItemQuality quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public SellIn retrieveSellIn() {
        return sellIn;
    }

    public ItemQuality retrieveQuality() {
        return quality;
    }
}