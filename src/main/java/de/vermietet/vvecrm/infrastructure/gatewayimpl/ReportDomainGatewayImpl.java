package de.vermietet.vvecrm.infrastructure.gatewayimpl;

import de.vermietet.vvecrm.domain.ReportDomain;
import de.vermietet.vvecrm.domain.gateway.ReportDomainGateway;
import de.vermietet.vvecrm.domain.model.VillageConsumptionReportData;
import de.vermietet.vvecrm.infrastructure.persistence.model.VillageConsumptionStatistic;
import de.vermietet.vvecrm.infrastructure.persistence.repository.VillageCounterLogJpaEntityRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Named
public class ReportDomainGatewayImpl implements ReportDomainGateway {
    private final VillageCounterLogJpaEntityRepository villageCounterLogJpaEntityRepository;

    @Inject
    public ReportDomainGatewayImpl(VillageCounterLogJpaEntityRepository villageCounterLogJpaEntityRepository) {
        this.villageCounterLogJpaEntityRepository = villageCounterLogJpaEntityRepository;
    }

    @Override
    public ReportDomain<VillageConsumptionReportData> getVillageConsumptionReportForPeriod(LocalDateTime start, LocalDateTime end) {
        Collection<VillageConsumptionStatistic> villageConsumptionStatistics = villageCounterLogJpaEntityRepository.findVillageConsumption(start, end);
        return new ReportDomain<>(
                villageConsumptionStatistics
                        .stream()
                        .map((v) -> new VillageConsumptionReportData(v.getVillageName(), v.getConsumption()))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteAll(boolean hardDelete) {
        if (hardDelete) {
            villageCounterLogJpaEntityRepository.deleteAll();
            villageCounterLogJpaEntityRepository.flush();
        }

        // TODO Else set all log status to DELETED
    }
}
