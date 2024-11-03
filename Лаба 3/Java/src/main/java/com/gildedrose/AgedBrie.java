package com.gildedrose;

public class AgedBrie extends InventoryItem {
    public static final String NAME = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(QualityUpdater updater) {
        increaseQuality(updater);
    }

    private void increaseQuality(QualityUpdater updater) {
        updater.increase();
    }

    @Override
    protected void processExpired(QualityUpdater updater) {
        increaseQuality(updater);
    }
}
