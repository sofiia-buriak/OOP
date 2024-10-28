package com.gildedrose;

public class SellIn {
    private int daysLeft;

    public SellIn(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public void decrease() {
        daysLeft--;
    }

    public boolean isExpired() {
        return daysLeft < 0;
    }

    @Override
    public String toString() {
        return String.valueOf(daysLeft);
    }
}
