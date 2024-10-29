package com.gildedrose;

public class InventoryItem {
    private Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void updateItem(Item item) {
        updateQuality(item);
        updateExpiration(item);
        if (isExpired(item)) {
            processExpired(item);
        }
    }

    protected static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    protected void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return; // Додано крапку з комою
        } else {
            decreaseQuality(item);
        }
    }

    protected void updateExpiration(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return; // Додано крапку з комою
        }
        item.sellIn--;
    }

    protected void processExpired(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            decreaseQuality(item);
        }
    }

}