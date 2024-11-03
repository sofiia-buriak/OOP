package com.gildedrose;

public class QualityUpdater {
    private final ItemProperties properties;

    public QualityUpdater(ItemProperties properties) {
        this.properties = properties;
    }

    public void decrease() {
        ItemQuality quality = properties.retrieveQuality();
        quality.decrease();
    }

    public void increase() {
        ItemQuality quality = properties.retrieveQuality();
        quality.increase();
    }
}