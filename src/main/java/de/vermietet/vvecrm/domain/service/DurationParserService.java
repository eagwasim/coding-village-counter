package de.vermietet.vvecrm.domain.service;

import de.vermietet.vvecrm.domain.model.DurationData;

public interface DurationParserService {
    DurationData parseDuration(String duration);
}
