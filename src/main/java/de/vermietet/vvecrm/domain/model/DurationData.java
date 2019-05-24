package de.vermietet.vvecrm.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DurationData {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
