package org.main;

import org.FinancialInstrument.FinancialInstrument;
import org.value.InstrumentName;
import org.value.MonetaryValue;
import org.value.RiskValue;
import org.factory.InstrumentFactory;
import org.factory.InstrumentPrototypeRegistry;
import org.factory.PrototypeRegistry;

public class FinancialSystem {
    public static void main(String[] args) {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        InstrumentFactory factory = new InstrumentFactory(registry);

        processInstrument(factory, "Stock", "AAPL", 1000.0);
        processInstrument(factory, "Bond", "Treasury", 5000.0);
        processInstrument(factory, "Derivative", "Option", 10000.0);
    }

    private static void processInstrument( InstrumentFactory factory, String type, String name, Double value ) {
        FinancialInstrument instrument = factory.create(type, new InstrumentName(name));

        calculateAndPrintRisk(instrument, value);
    }

    private static void calculateAndPrintRisk( FinancialInstrument instrument, Double value ) {
        RiskValue risk = instrument.calculateRisk(new MonetaryValue(value));
        instrument.recordRisk(risk);

        System.out.println(instrument + ", Risk: " + instrument.retrieveRisk());
    }
}