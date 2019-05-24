package de.vermietet.vvecrm.infrastructure.web.model;

import de.vermietet.vvecrm.usecases.model.RegisterVillageRequest;
import de.vermietet.vvecrm.usecases.model.contract.UseCaseModelConvertible;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RegisterVillageControllerRequestData implements UseCaseModelConvertible<RegisterVillageRequest> {
    @NotNull
    private Long id;
    @NotBlank
    @NotNull
    private String name;

    @Override
    public RegisterVillageRequest toUseCaseModel() {
        return new RegisterVillageRequest(id, name);
    }
}
