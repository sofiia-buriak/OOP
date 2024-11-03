package com.gildedrose;

public class InventoryItem {
    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void dailyUpdate() {
        QualityUpdater updater = new QualityUpdater(fetchItemProperties());
        updateQuality(updater);
        updateExpiration();
        if (isExpired()) {
            processExpired(updater);
        }
    }

    protected void updateQuality(QualityUpdater updater) {
        updater.decrease();
    }

    protected void updateExpiration() {
        ItemProperties properties = fetchItemProperties();
        SellIn sellIn = properties.retrieveSellIn();
        sellIn.decrease();
    }

    protected boolean isExpired() {
        ItemProperties properties = fetchItemProperties();
        SellIn sellIn = properties.retrieveSellIn();
        return sellIn.isExpired();
    }

    protected void processExpired(QualityUpdater updater) {
        updater.decrease();
    }

    public ItemProperties fetchItemProperties() {
        return item.retrieveProperties();
    }
}