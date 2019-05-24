package de.vermietet.vvecrm.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCounterResponse {
    private Long id;
    private String address;
    private GetCounterVillageResponse village;
}
