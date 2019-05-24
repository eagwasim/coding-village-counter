package de.vermietet.vvecrm.infrastructure.persistence.repository;

import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.VillageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageJpaEntityRepository extends JpaRepository<VillageJpaEntity, Long> {
}
