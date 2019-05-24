package de.vermietet.vvecrm.domain.gateway;

import de.vermietet.vvecrm.domain.VillageDomain;

public interface VillageDomainGateway {
    VillageDomain registerVillage(Long id, String name);

    void deleteAllVillages(boolean hardDelete);
}
