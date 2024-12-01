package org.factory;

import org.FinancialInstrument.FinancialInstrument;

public interface PrototypeRegistry {
    FinancialInstrument obtainPrototype(String type);
    void registerPrototype(String type, FinancialInstrument prototype);
}
