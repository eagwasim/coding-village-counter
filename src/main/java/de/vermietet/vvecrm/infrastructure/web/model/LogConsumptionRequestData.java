package de.vermietet.vvecrm.infrastructure.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogConsumptionRequestData {
    @NotNull
    private BigDecimal amount;
}
