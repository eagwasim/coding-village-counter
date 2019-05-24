package de.vermietet.vvecrm.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterVillageRequest {
    private Long id;
    private String name;
}
