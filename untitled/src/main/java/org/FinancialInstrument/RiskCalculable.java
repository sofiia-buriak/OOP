package org.FinancialInstrument;

import org.value.MonetaryValue;
import org.value.RiskValue;

public interface RiskCalculable {
    RiskValue calculateRisk(MonetaryValue value);
}
