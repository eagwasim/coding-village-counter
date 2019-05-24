package de.vermietet.vvecrm.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageConsumptionReportResponse {
    private String villageName;
    private BigDecimal consumption;
}
