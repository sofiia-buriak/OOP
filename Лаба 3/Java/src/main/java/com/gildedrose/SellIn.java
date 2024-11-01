package com.gildedrose;

public class SellIn {
    private IntegerValue value;

    public SellIn(IntegerValue value) {
        this.value = value;
    }

    public int getDays() {
        return value.getValue();
    }

    public void decrease() {
        value = value.decrement();
    }

    public boolean isExpired() {
        return value.isLessThan(0);
    }
}