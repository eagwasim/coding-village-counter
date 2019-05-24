package de.vermietet.vvecrm.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCounterRequest {
    private Long counterId;
    private Long villageId;
    private String counterAddress;
}
