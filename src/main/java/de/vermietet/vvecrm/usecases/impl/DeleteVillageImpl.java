package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.gateway.VillageDomainGateway;
import de.vermietet.vvecrm.usecases.DeleteVillage;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DeleteVillageImpl implements DeleteVillage {
    private final VillageDomainGateway villageDomainGateway;

    @Inject
    public DeleteVillageImpl(VillageDomainGateway villageDomainGateway) {
        this.villageDomainGateway = villageDomainGateway;
    }

    @Override
    public void deleteVillage(boolean hardDelete) {
        villageDomainGateway.deleteAllVillages(hardDelete);
    }
}
