package de.vermietet.vvecrm.infrastructure.web.model;

import de.vermietet.vvecrm.usecases.model.RegisterCounterRequest;
import de.vermietet.vvecrm.usecases.model.contract.UseCaseModelConvertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCounterControllerRequestData implements UseCaseModelConvertible<RegisterCounterRequest> {
    @NotNull
    private Long id;
    @NotNull
    private Long villageId;
    @NotNull
    private String address;

    @Override
    public RegisterCounterRequest toUseCaseModel() {
        return new RegisterCounterRequest(id, villageId, address);
    }
}
