package org.FinancialInstrument;

import org.FinancialInstrument.FinancialInstrument;
import org.value.InstrumentName;
import org.value.RiskValue;

public abstract class FinancialInstrument implements RiskCalculable, ClonableFinancialInstrument, Cloneable {
    protected InstrumentName instrumentName;
    private RiskValue instrumentRisk;

    public FinancialInstrument(InstrumentName name) {
        this.instrumentName = name;
    }

    public void setInstrumentName(InstrumentName name) {
        this.instrumentName = name;
    }

    public void recordRisk(RiskValue risk) {
        this.instrumentRisk = risk;
    }

    public RiskValue retrieveRisk() {
        return instrumentRisk;
    }

    @Override
    public FinancialInstrument cloneInstrument() {
        try {
            FinancialInstrument clone = (FinancialInstrument) super.clone();
            clone.setInstrumentName(new InstrumentName(this.instrumentName.reveal())); 
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
