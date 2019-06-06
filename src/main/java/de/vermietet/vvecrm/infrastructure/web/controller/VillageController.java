package de.vermietet.vvecrm.infrastructure.web.controller;

import de.vermietet.vvecrm.infrastructure.web.model.RegisterVillageControllerRequestData;
import de.vermietet.vvecrm.usecases.DeleteVillage;
import de.vermietet.vvecrm.usecases.RegisterVillage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
public class VillageController {
    private final RegisterVillage registerVillage;
    private final DeleteVillage deleteVillage;

    @Inject
    public VillageController(RegisterVillage registerVillage, DeleteVillage deleteVillage) {
        this.registerVillage = registerVillage;
        this.deleteVillage = deleteVillage;
    }

    @RequestMapping(path = "/api/v1/villages", method = RequestMethod.POST)
    public ResponseEntity<?> registerVillage(@Valid @RequestBody RegisterVillageControllerRequestData requestData) {
        registerVillage.registerVillage(requestData.toUseCaseModel());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/api/v1/villages", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVillages(@RequestParam("hardDelete") boolean hardDelete) {
        deleteVillage.deleteVillage(hardDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
