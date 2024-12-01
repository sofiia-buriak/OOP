import static org.junit.Assert.*;
import org.junit.Test;

import org.FinancialInstrument.Bond;
import org.FinancialInstrument.Derivative;
import org.FinancialInstrument.FinancialInstrument;
import org.FinancialInstrument.Stock;
import org.factory.InstrumentFactory;
import org.value.InstrumentName;
import org.factory.InstrumentPrototypeRegistry;
import org.value.MonetaryValue;
import org.factory.PrototypeRegistry;
import org.value.RiskValue;

public class FinancialSystemTest {

    @Test
    public void testStockRiskCalculation() {
        FinancialInstrument instrument = new Stock(new InstrumentName("AAPL"));
        RiskValue risk = instrument.calculateRisk(new MonetaryValue(1000.0));
        assertEquals("1.0", risk.toString());
    }

    @Test
    public void testBondRiskCalculation() {
        FinancialInstrument instrument = new Bond(new InstrumentName("Treasury"));
        RiskValue risk = instrument.calculateRisk(new MonetaryValue(5000.0));
        assertEquals("10.0", risk.toString());
    }

    @Test
    public void testDerivativeRiskCalculation() {
        FinancialInstrument instrument = new Derivative(new InstrumentName("Option"));
        RiskValue risk = instrument.calculateRisk(new MonetaryValue(10000.0));
        assertEquals("50.0", risk.toString());
    }

    @Test
    public void testCloneStock() {
        FinancialInstrument original = new Stock(new InstrumentName("AAPL"));
        FinancialInstrument clone = original.cloneInstrument();
        assertNotSame(original, clone);
        assertEquals("Stock: AAPL", clone.toString());
    }

    @Test
    public void testPrototypeCreation() {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        InstrumentFactory factory = new InstrumentFactory(registry);
        FinancialInstrument instrument = factory.create("Stock", new InstrumentName("MSFT"));
        assertEquals("Stock: MSFT", instrument.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownType() {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        InstrumentFactory factory = new InstrumentFactory(registry);
        factory.create("Unknown", new InstrumentName("Unknown"));
    }

    @Test
    public void testCloneWithDifferentNames() {
        FinancialInstrument original = new Stock(new InstrumentName("AAPL"));
        FinancialInstrument clone = original.cloneInstrument();
        clone.setInstrumentName(new InstrumentName("GOOG"));
        assertEquals("Stock: AAPL", original.toString());
        assertEquals("Stock: GOOG", clone.toString());
    }

    @Test
    public void testRecordAndRetrieveRisk() {
        FinancialInstrument instrument = new Stock(new InstrumentName("AAPL"));
        RiskValue risk = new RiskValue(1.0);
        instrument.recordRisk(risk);
        assertEquals(risk, instrument.retrieveRisk());
    }

    @Test
    public void testRegisterAndCreateNewPrototype() {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        FinancialInstrument newPrototype = new Stock(new InstrumentName("NewPrototype"));
        registry.registerPrototype("NewType", newPrototype);
        
        InstrumentFactory factory = new InstrumentFactory(registry);
        FinancialInstrument instrument = factory.create("NewType", new InstrumentName("NewInstance"));
        assertEquals("Stock: NewInstance", instrument.toString());
    }

    @Test
    public void testRegisterAndRetrievePrototype() {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        FinancialInstrument prototype = new Stock(new InstrumentName("Default"));
        registry.registerPrototype("TestStock", prototype);
        
        FinancialInstrument retrievedPrototype = registry.obtainPrototype("TestStock");
        assertEquals(prototype, retrievedPrototype);
    }

    @Test
    public void testCloneWithDifferentParameters() {
        FinancialInstrument original = new Stock(new InstrumentName("AAPL"));
        FinancialInstrument clone = original.cloneInstrument();
        clone.setInstrumentName(new InstrumentName("GOOG"));
        
        assertNotSame(original, clone);
        assertEquals("Stock: AAPL", original.toString());
        assertEquals("Stock: GOOG", clone.toString());
    }

    @Test
    public void testCalculateRiskForNewType() {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        FinancialInstrument newPrototype = new Stock(new InstrumentName("NewType"));
        registry.registerPrototype("NewType", newPrototype);
        
        InstrumentFactory factory = new InstrumentFactory(registry);
        FinancialInstrument instrument = factory.create("NewType", new InstrumentName("NewInstance"));
        RiskValue risk = instrument.calculateRisk(new MonetaryValue(2000.0));
        assertEquals("2.0", risk.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionForUnknownType() {
        PrototypeRegistry registry = new InstrumentPrototypeRegistry();
        InstrumentFactory factory = new InstrumentFactory(registry);
        factory.create("UnknownType", new InstrumentName("UnknownInstance"));
    }
}