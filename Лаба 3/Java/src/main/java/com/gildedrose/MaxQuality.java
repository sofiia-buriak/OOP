package com.gildedrose;

public class MaxQuality {
    private final IntegerValue value;

    public MaxQuality() {
        this.value = new IntegerValue(50);
    }

    public boolean isLessThan(IntegerValue other) {
        int otherValue = other.fetchValue();
        int thisValue = value.fetchValue();
        return otherValue < thisValue;
    }
}
