package com.gildedrose;

public class SellIn {
    private IntegerValue value;

    public SellIn(IntegerValue value) {
        this.value = value;
    }

    public int obtainDays() {
        return value.fetchValue();
    }

    public void decrease() {
        value = value.decrement();
    }

    public boolean isExpired() {
        return value.isLessThan(0);
    }
}