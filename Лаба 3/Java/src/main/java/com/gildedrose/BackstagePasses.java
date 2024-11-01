package com.gildedrose;

public class BackstagePasses extends InventoryItem {
    public static final ItemName NAME = new ItemName("Backstage passes to a TAFKAL80ETC concert");

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(QualityUpdater updater) {
        updater.increase();
        int sellInDays = fetchSellInDays();
        if (sellInDays < 11) {
            updater.increase();
        }
        if (sellInDays < 6) {
            updater.increase();
        }
    }

    private int fetchSellInDays() {
        ItemProperties properties = fetchItemProperties();
        SellIn sellIn = properties.retrieveSellIn();
        return sellIn.obtainDays();
    }

    @Override
    protected void processExpired(QualityUpdater updater) {
        ItemProperties properties = fetchItemProperties();
        ItemQuality quality = properties.retrieveQuality();
        quality.assignValue(new IntegerValue(0));
    }

    private ItemProperties fetchItemProperties() {
        return item.retrieveProperties();
    }
}