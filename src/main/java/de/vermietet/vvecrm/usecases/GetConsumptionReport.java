package de.vermietet.vvecrm.usecases;

import de.vermietet.vvecrm.usecases.model.VillageConsumptionReportResponse;

import java.util.Collection;

public interface GetConsumptionReport {
    Collection<VillageConsumptionReportResponse> getVillageConsumptionReport(String duration);
}
