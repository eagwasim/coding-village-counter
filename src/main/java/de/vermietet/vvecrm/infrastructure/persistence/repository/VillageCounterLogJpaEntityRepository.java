package de.vermietet.vvecrm.infrastructure.persistence.repository;

import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.VillageCounterLogJpaEntity;
import de.vermietet.vvecrm.infrastructure.persistence.model.VillageConsumptionStatistic;
import de.vermietet.vvecrm.infrastructure.persistence.queryset.VillageCounterLogJpaEntityQuerySet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Collection;

public interface VillageCounterLogJpaEntityRepository extends JpaRepository<VillageCounterLogJpaEntity, Long> {

    @Query(VillageCounterLogJpaEntityQuerySet.VILLAGE_CONSUMPTION_QUERY)
    Collection<VillageConsumptionStatistic> findVillageConsumption(LocalDateTime startTime, LocalDateTime endTime);
}
