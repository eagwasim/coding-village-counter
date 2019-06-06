package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.gateway.CounterDomainGateway;
import de.vermietet.vvecrm.usecases.LogConsumption;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class LogConsumptionImpl implements LogConsumption {
    private final CounterDomainGateway counterDomainGateway;

    @Inject
    public LogConsumptionImpl(CounterDomainGateway counterDomainGateway) {
        this.counterDomainGateway = counterDomainGateway;
    }

    @Override
    public void logConsumption(Long counterId, BigDecimal consumption) {
        counterDomainGateway.logConsumption(counterId, consumption);
    }
}
