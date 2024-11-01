package com.gildedrose;

public class ItemQuality {
    private IntegerValue value;
    private final MaxQuality maxQuality;

    public ItemQuality(IntegerValue value) {
        this.value = value;
        this.maxQuality = new MaxQuality();
    }

    public int obtainIntValue() {
        return value.fetchValue();
    }

    public void increase() {
        if (maxQuality.isLessThan(value)) {
            value = value.increment();
        }
    }

    public void decrease() {
        if (value.isPositive()) {
            value = value.decrement();
        }
    }

    public void assignValue(IntegerValue value) {
        this.value = value;
    }
}