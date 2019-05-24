package de.vermietet.vvecrm.usecases;

import de.vermietet.vvecrm.usecases.model.RegisterCounterRequest;
import de.vermietet.vvecrm.usecases.model.RegisterCounterResponse;

public interface RegisterCounter {
    RegisterCounterResponse registerCounter(RegisterCounterRequest registerCounterRequest);
}
