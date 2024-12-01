package org.value;

public class RiskValue {
    private final Double amount;

    public RiskValue(Double amount) {
        this.amount = amount;
    }

    public String toString() {
        return amount.toString();
    }
}
