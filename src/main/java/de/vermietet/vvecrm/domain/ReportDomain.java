package de.vermietet.vvecrm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ReportDomain<T> {
    private Collection<T> data;
}
