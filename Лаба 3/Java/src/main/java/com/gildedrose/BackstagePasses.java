package com.gildedrose;

public class BackstagePasses extends InventoryItem {
    public static final ItemName NAME = new ItemName("Backstage passes to a TAFKAL80ETC concert");

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(QualityUpdater updater) {
        updater.increase();
        int sellInDays = getSellInDays();
        if (sellInDays < 11) {
            updater.increase();
        }
        if (sellInDays < 6) {
            updater.increase();
        }
    }

    private int getSellInDays() {
        ItemProperties properties = getItemProperties();
        SellIn sellIn = properties.getSellIn();
        return sellIn.getDays();
    }

    @Override
    protected void processExpired(QualityUpdater updater) {
        ItemProperties properties = getItemProperties();
        ItemQuality quality = properties.getQuality();
        quality.setValue(new IntegerValue(0));
    }

    private ItemProperties getItemProperties() {
        return item.getProperties();
    }
}