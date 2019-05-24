package de.vermietet.vvecrm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class VillageDomain {
    private Long id;
    private String name;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
