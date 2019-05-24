package de.vermietet.vvecrm.infrastructure.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCounterControllerResponseData {
    private Long id;
    private String villageName;
}
