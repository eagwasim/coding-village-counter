package de.vermietet.vvecrm.usecases.impl;

import de.vermietet.vvecrm.domain.ReportDomain;
import de.vermietet.vvecrm.domain.gateway.ReportDomainGateway;
import de.vermietet.vvecrm.domain.model.DurationData;
import de.vermietet.vvecrm.domain.model.VillageConsumptionReportData;
import de.vermietet.vvecrm.domain.service.DurationParserService;
import de.vermietet.vvecrm.usecases.GetConsumptionReport;
import de.vermietet.vvecrm.usecases.model.VillageConsumptionReportResponse;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.stream.Collectors;

@Named
public class GetConsumptionReportImpl implements GetConsumptionReport {
    private final ReportDomainGateway reportDomainGateway;
    private final DurationParserService durationParserService;

    @Inject
    public GetConsumptionReportImpl(ReportDomainGateway reportDomainGateway, DurationParserService durationParserService) {
        this.reportDomainGateway = reportDomainGateway;
        this.durationParserService = durationParserService;
    }

    @Override
    public Collection<VillageConsumptionReportResponse> getVillageConsumptionReport(String duration) {
        DurationData durationData = durationParserService.parseDuration(duration);

        ReportDomain<VillageConsumptionReportData> villageConsumptionReportDataReportDomain = reportDomainGateway.getVillageConsumptionReportForPeriod(durationData.getStartTime(), durationData.getEndTime());

        return villageConsumptionReportDataReportDomain
                .getData()
                .stream()
                .map((v) -> new VillageConsumptionReportResponse(v.getVillageName(), v.getConsumption()))
                .collect(Collectors.toList());
    }
}
