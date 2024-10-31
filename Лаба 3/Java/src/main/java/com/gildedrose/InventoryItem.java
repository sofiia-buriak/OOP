package com.gildedrose;

public class InventoryItem {
    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void dailyUpdate() {
        QualityUpdater updater = new QualityUpdater(item.getProperties());
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
        item.getProperties().getSellIn().decrease();
    }

    protected boolean isExpired() {
        return item.getProperties().getSellIn().isExpired();
    }

    protected void processExpired(QualityUpdater updater) {
        updater.decrease();
    }
}