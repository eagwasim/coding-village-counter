package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.gateway.CounterDomainGateway;
import de.vermietet.vvecrm.usecases.RegisterCounter;
import de.vermietet.vvecrm.usecases.model.RegisterCounterRequest;
import de.vermietet.vvecrm.usecases.model.RegisterCounterResponse;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisterCounterImpl implements RegisterCounter {
    private final CounterDomainGateway counterDomainGateway;

    @Inject
    public RegisterCounterImpl(CounterDomainGateway counterDomainGateway) {
        this.counterDomainGateway = counterDomainGateway;
    }

    @Override
    public RegisterCounterResponse registerCounter(RegisterCounterRequest registerCounterRequest) {
        counterDomainGateway.registerCounter(registerCounterRequest.getCounterId(), registerCounterRequest.getCounterAddress(), registerCounterRequest.getVillageId());
        return new RegisterCounterResponse(registerCounterRequest.getCounterId());
    }
}
