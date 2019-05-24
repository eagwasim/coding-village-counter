package de.vermietet.vvecrm.usecases;

import de.vermietet.vvecrm.usecases.model.RegisterVillageRequest;
import de.vermietet.vvecrm.usecases.model.RegisterVillageResponse;

public interface RegisterVillage {
    RegisterVillageResponse registerVillage(RegisterVillageRequest registerVillageRequest);
}
