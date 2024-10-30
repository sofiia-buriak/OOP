package com.gildedrose;

public class InventoryItem {
    public static final String AGED_BRIE = "Aged Brie";
    private Item item;

    public static create(Item item){
        return new InventoryItem(item);
    }

    public InventoryItem(Item item) {
        this.item = item;
    }



    public void dailyItem(Item item) {
        updateQuality();
        updateExpiration();
        if (isExpired()) {
            processExpired();
        }
    }

    protected static void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected static boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void updateQuality() {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            decreaseQuality();
        }
    }

    protected void updateExpiration() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void processExpired() {
        if (item.name.equals("Aged Brie")) {
            increaseQuality();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            decreaseQuality();
        }
    }

}