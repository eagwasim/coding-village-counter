package de.vermietet.vvecrm.infrastructure.persistence.jpaentities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "village_counter_log")
@AllArgsConstructor
@NoArgsConstructor
public class VillageCounterLogJpaEntity extends AbstractJpaEntityAutoId<Long> {
    private Long villageId;
    private Long counterId;
    private BigDecimal amount;
}
