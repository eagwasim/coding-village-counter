package de.vermietet.vvecrm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CounterDomain {
    private Long id;
    private String address;
    private VillageDomain village;
}
