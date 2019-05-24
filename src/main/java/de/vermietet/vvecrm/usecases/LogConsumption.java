package de.vermietet.vvecrm.usecases;

import java.math.BigDecimal;

public interface LogConsumption {
    void logConsumption(Long counterId, BigDecimal consumption);
}
