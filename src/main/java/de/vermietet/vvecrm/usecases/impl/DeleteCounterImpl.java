package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.gateway.CounterDomainGateway;
import de.vermietet.vvecrm.usecases.DeleteCounter;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DeleteCounterImpl implements DeleteCounter {
    private final CounterDomainGateway counterDomainGateway;

    @Inject
    public DeleteCounterImpl(CounterDomainGateway counterDomainGateway) {
        this.counterDomainGateway = counterDomainGateway;
    }

    @Override
    public void deleteAll(boolean hardDelete) {
        counterDomainGateway.deleteAll(hardDelete);
    }
}
