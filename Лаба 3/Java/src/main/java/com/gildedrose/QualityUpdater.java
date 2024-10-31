package com.gildedrose;

public class QualityUpdater {
    private final ItemProperties properties;

    public QualityUpdater(ItemProperties properties) {
        this.properties = properties;
    }

    public void decrease() {
        properties.getQuality().decrease();
    }

    public void increase() {
        properties.getQuality().increase();
    }
}