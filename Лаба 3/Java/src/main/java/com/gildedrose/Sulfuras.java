package com.gildedrose;

public class Sulfuras extends InventoryItem {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {}

    @Override
    protected void updateExpiration() {}

    @Override
    protected void processExpired() {}
}