package org.factory;

import org.FinancialInstrument.FinancialInstrument;
import org.value.InstrumentName;

public class InstrumentFactory {
    private PrototypeRegistry prototypes;

    public InstrumentFactory(PrototypeRegistry prototypes) {
        this.prototypes = prototypes;
    }

    public FinancialInstrument create(String type, InstrumentName name) {
        FinancialInstrument prototype = prototypes.obtainPrototype(type);

        throwIfPrototypeNotFound(prototype, type);

        return clonePrototypeWithName(prototype, name);
    }

    private void throwIfPrototypeNotFound(FinancialInstrument prototype, String type) {
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    private FinancialInstrument clonePrototypeWithName(FinancialInstrument prototype, InstrumentName name) {
        FinancialInstrument clone = prototype.cloneInstrument();
        clone.setInstrumentName(name); 
        return clone;
    }
}
