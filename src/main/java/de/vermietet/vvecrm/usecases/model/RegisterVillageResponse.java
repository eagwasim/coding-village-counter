package de.vermietet.vvecrm.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterVillageResponse {
    private Long id;
    private String name;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
