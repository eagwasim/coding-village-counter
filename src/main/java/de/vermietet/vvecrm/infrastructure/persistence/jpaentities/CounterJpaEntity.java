package de.vermietet.vvecrm.infrastructure.persistence.jpaentities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "metre_counter")
@AllArgsConstructor
@NoArgsConstructor
public class CounterJpaEntity extends AbstractJpaEntity<Long> {
    @ManyToOne
    private VillageJpaEntity village;
    private String address;
}
