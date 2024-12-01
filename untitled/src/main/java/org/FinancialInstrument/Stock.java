package org.FinancialInstrument;

import org.value.InstrumentName;
import org.value.MonetaryValue;
import org.value.RiskValue;

public class Stock extends FinancialInstrument {
    public Stock(InstrumentName name) {
        super(name);
    }

    @Override
    public RiskValue calculateRisk(MonetaryValue value) {
        return new RiskValue(value.extractValue() / 1000);
    }

    @Override
    public String toString() {
        return "Stock: " + instrumentName.reveal();
    }
}