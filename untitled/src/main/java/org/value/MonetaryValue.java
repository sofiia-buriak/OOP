package org.value;

public class MonetaryValue {
    private final Double amount;

    public MonetaryValue(Double amount) {
        this.amount = amount;
    }

    public Double extractValue() {
        return amount;
    }
}
