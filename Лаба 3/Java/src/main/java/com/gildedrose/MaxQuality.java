package com.gildedrose;

public class MaxQuality {
    private final IntegerValue value;

    public MaxQuality() {
        this.value = new IntegerValue(50);
    }

    public boolean isLessThan(IntegerValue other) {
        int otherValue = other.getValue();
        int thisValue = value.getValue();
        return otherValue < thisValue;
    }
}
