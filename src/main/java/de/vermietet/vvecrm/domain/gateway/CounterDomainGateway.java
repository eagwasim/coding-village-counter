package de.vermietet.vvecrm.domain.gateway;

import de.vermietet.vvecrm.domain.CounterDomain;

import java.math.BigDecimal;

public interface CounterDomainGateway {
    CounterDomain registerCounter(Long id, String name, Long villageId);

    CounterDomain getCounterById(Long id);

    void deleteAll(boolean hardDelete);

    void logConsumption(Long counterId, BigDecimal amount);
}
