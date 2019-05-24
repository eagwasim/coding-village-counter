package de.vermietet.vvecrm.infrastructure.persistence.repository;

import de.vermietet.vvecrm.infrastructure.persistence.jpaentities.CounterJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterJpaEntityRepository extends JpaRepository<CounterJpaEntity, Long> {
}
