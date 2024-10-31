package com.gildedrose;

public class ItemName {
    private final String value;

    public ItemName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(String other) {
        return value.equals(other);
    }
}
