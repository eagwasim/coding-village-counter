package de.vermietet.vvecrm.domain.gateway;

import de.vermietet.vvecrm.domain.ReportDomain;
import de.vermietet.vvecrm.domain.model.VillageConsumptionReportData;

import java.time.LocalDateTime;

public interface ReportDomainGateway {
    ReportDomain<VillageConsumptionReportData> getVillageConsumptionReportForPeriod(LocalDateTime start, LocalDateTime end);

    void deleteAll(boolean hardDelete);
}
