package de.vermietet.vvecrm.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageConsumptionReportData {
    private String villageName;
    private BigDecimal consumption;
}
