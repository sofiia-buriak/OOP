package com.gildedrose;

public class ProductName {
    private String value;

    public ProductName(String value) {
        this.value = value;
    }

    public boolean isAgedBrie() {
        return value.equals("Aged Brie");
    }

    public boolean isBackstagePass() {
        return value.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfuras() {
        return value.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public String toString() {
        return value;
    }
}
