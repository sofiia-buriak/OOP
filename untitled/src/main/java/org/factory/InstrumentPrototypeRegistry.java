package org.factory;
import java.util.HashMap;
import java.util.Map;

import org.FinancialInstrument.Bond;
import org.FinancialInstrument.Derivative;
import org.FinancialInstrument.Stock;
import org.value.InstrumentName;
import org.FinancialInstrument.FinancialInstrument;

public class InstrumentPrototypeRegistry implements PrototypeRegistry {
    private Map<String, FinancialInstrument> prototypes = new HashMap<>();

    public InstrumentPrototypeRegistry() {
        registerPrototype("Stock", new Stock(new InstrumentName("Default")));
        registerPrototype("Bond", new Bond(new InstrumentName("Default")));
        registerPrototype("Derivative", new Derivative(new InstrumentName("Default")));
    }

    @Override
    public FinancialInstrument obtainPrototype(String type) {
        return prototypes.get(type);
    }

    @Override
    public void registerPrototype(String type, FinancialInstrument prototype) {
        prototypes.put(type, prototype);
    }
}