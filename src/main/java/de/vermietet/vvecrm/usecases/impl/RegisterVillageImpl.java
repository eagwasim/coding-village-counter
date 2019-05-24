package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.VillageDomain;
import de.vermietet.vvecrm.domain.gateway.VillageDomainGateway;
import de.vermietet.vvecrm.usecases.RegisterVillage;
import de.vermietet.vvecrm.usecases.model.RegisterVillageRequest;
import de.vermietet.vvecrm.usecases.model.RegisterVillageResponse;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisterVillageImpl implements RegisterVillage {
    private final VillageDomainGateway villageDomainGateway;

    @Inject
    public RegisterVillageImpl(VillageDomainGateway villageDomainGateway) {
        this.villageDomainGateway = villageDomainGateway;
    }

    @Override
    public RegisterVillageResponse registerVillage(RegisterVillageRequest registerVillageRequest) {
        VillageDomain villageDomain = villageDomainGateway.registerVillage(registerVillageRequest.getId(), registerVillageRequest.getName());

        return new RegisterVillageResponse(villageDomain.getId(), villageDomain.getName(), villageDomain.getDateCreated(), villageDomain.getLastUpdated());
    }
}
