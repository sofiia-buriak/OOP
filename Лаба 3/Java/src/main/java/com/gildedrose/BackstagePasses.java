package com.gildedrose;

public class BackstagePasses extends InventoryItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(QualityUpdater updater) {
        increaseQuality(updater);
        applyBonus(updater, fetchSellInDays());
    }

    private void increaseQuality(QualityUpdater updater) {
        updater.increase();
    }

    private int fetchSellInDays() {
        ItemProperties properties = fetchItemProperties();
        SellIn sellIn = properties.retrieveSellIn();
        return sellIn.obtainDays();
    }

    private void applyBonus(QualityUpdater updater, int sellInDays) {
        applyFirstBonus(updater, sellInDays);
        applySecondBonus(updater, sellInDays);
    }

    private void applyFirstBonus(QualityUpdater updater, int sellInDays) {
        if (sellInDays < 11) {
            updater.increase();
        }
    }

    private void applySecondBonus(QualityUpdater updater, int sellInDays) {
        if (sellInDays < 6) {
            updater.increase();
        }
    }

    @Override
    protected void processExpired(QualityUpdater updater) {
        ItemProperties properties = fetchItemProperties();
        ItemQuality quality = properties.retrieveQuality();
        quality.assignValue(new IntegerValue(0));
    }
}
