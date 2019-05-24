package de.vermietet.vvecrm.usecases;

import de.vermietet.vvecrm.usecases.model.GetCounterResponse;

public interface GetCounter {
    GetCounterResponse getCounterById(Long id);
}
