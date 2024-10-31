package com.gildedrose;

public class BackstagePasses extends InventoryItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(QualityUpdater updater) {
        updater.increase();

        SellIn sellIn = item.getProperties().getSellIn();
        if (sellIn.getValue() < 11) {
            updater.increase();
        }
        if (sellIn.getValue() < 6) {
            updater.increase();
        }
    }

    @Override
    protected void processExpired(QualityUpdater updater) {
        item.getProperties().getQuality().setValue(0);
    }
}