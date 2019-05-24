package de.vermietet.vvecrm.infrastructure.persistence.jpaentities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "village")
@Getter
@Setter
public class VillageJpaEntity extends AbstractJpaEntity<Long> {
    private String name;
}
