package com.gildedrose;

public class Sulfuras extends InventoryItem {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality(QualityUpdater updater) { }

    @Override
    protected void updateExpiration() { }
}