package com.gildedrose;

public class Quality {
    private int value;

    public Quality(int initialValue) {
        value = initialValue;
    }

    public void increase() {
        if (value < 50) {
            value++;
        }
    }

    public void decrease() {
        if (value > 0) {
            value--;
        }
    }

    public void reset() {
        value = 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

