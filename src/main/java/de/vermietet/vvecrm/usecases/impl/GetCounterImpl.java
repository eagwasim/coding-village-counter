package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.CounterDomain;
import de.vermietet.vvecrm.domain.gateway.CounterDomainGateway;
import de.vermietet.vvecrm.usecases.GetCounter;
import de.vermietet.vvecrm.usecases.model.GetCounterResponse;
import de.vermietet.vvecrm.usecases.model.GetCounterVillageResponse;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GetCounterImpl implements GetCounter {
    private final CounterDomainGateway counterDomainGateway;

    @Inject
    public GetCounterImpl(CounterDomainGateway counterDomainGateway) {
        this.counterDomainGateway = counterDomainGateway;
    }

    @Override
    public GetCounterResponse getCounterById(Long id) {
        CounterDomain counterDomain = counterDomainGateway.getCounterById(id);
        return new GetCounterResponse(counterDomain.getId(), counterDomain.getAddress(), new GetCounterVillageResponse(counterDomain.getVillage().getId(), counterDomain.getVillage().getName()));
    }
}
