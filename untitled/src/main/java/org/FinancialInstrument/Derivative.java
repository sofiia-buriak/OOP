package org.FinancialInstrument;

import org.value.InstrumentName;
import org.value.MonetaryValue;
import org.value.RiskValue;

public class Derivative extends FinancialInstrument {
    public Derivative(InstrumentName name) {
        super(name);
    }

    @Override
    public RiskValue calculateRisk(MonetaryValue value) {
        return new RiskValue(value.extractValue() / 200);
    }

    @Override
    public String toString() {
        return "Derivative: " + instrumentName.reveal();
    }
}
