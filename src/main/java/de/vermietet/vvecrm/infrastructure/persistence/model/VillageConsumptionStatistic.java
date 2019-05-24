package de.vermietet.vvecrm.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageConsumptionStatistic {
    private String villageName;
    private BigDecimal consumption;
}
