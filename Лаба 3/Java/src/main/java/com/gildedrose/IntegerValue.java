package com.gildedrose;

public class IntegerValue {
    private final int value;

    public IntegerValue(int value) {
        this.value = value;
    }

    public int fetchValue() {
        return value;
    }

    public IntegerValue increment() {
        return new IntegerValue(value + 1);
    }

    public IntegerValue decrement() {
        return new IntegerValue(value - 1);
    }

    public boolean isPositive() {
        return value > 0;
    }

    public boolean isLessThan(int other) {
        return value < other;
    }
}

