package com.gildedrose;

public class InventoryItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    protected Item item;

    public static InventoryItem create(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie(item);
        }
        if (item.name.equals(BACKSTAGE_PASSES)) {
            return new BackstagePasses(item);
        }
        if (item.name.equals(SULFURAS)) {
            return new Sulfuras(item);
        }
        return new InventoryItem(item);
    }

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void dailyUpdate() {
        updateQuality();
        updateExpiration();
        if (isExpired()) {
            processExpired();
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateExpiration() {
        item.sellIn--;
    }

    protected void processExpired() {
        decreaseQuality();
    }
}