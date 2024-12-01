package org.FinancialInstrument;

import org.value.InstrumentName;
import org.value.MonetaryValue;
import org.value.RiskValue;

public class Bond extends FinancialInstrument {
    public Bond(InstrumentName name) {
        super(name);
    }

    @Override
    public RiskValue calculateRisk(MonetaryValue value) {
        return new RiskValue(value.extractValue() / 500);
    }

    @Override
    public String toString() {
        return "Bond: " + instrumentName.reveal();
    }
}
