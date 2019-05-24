package de.vermietet.vvecrm.infrastructure.web.controller;

import de.vermietet.vvecrm.infrastructure.web.model.GetCounterControllerResponseData;
import de.vermietet.vvecrm.infrastructure.web.model.LogConsumptionRequestData;
import de.vermietet.vvecrm.infrastructure.web.model.RegisterCounterControllerRequestData;
import de.vermietet.vvecrm.usecases.DeleteCounter;
import de.vermietet.vvecrm.usecases.GetCounter;
import de.vermietet.vvecrm.usecases.LogConsumption;
import de.vermietet.vvecrm.usecases.RegisterCounter;
import de.vermietet.vvecrm.usecases.model.GetCounterResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
public class CounterController {
    private final RegisterCounter registerCounter;
    private final GetCounter getCounter;
    private final DeleteCounter deleteCounter;
    private final LogConsumption logConsumption;

    @Inject
    public CounterController(RegisterCounter registerCounter, GetCounter getCounter, DeleteCounter deleteCounter, LogConsumption logConsumption) {
        this.registerCounter = registerCounter;
        this.getCounter = getCounter;
        this.deleteCounter = deleteCounter;
        this.logConsumption = logConsumption;
    }


    @RequestMapping(path = "/api/v1/counters", method = RequestMethod.POST)
    public ResponseEntity<?> registerCounter(@Valid @RequestBody RegisterCounterControllerRequestData requestData) {
        registerCounter.registerCounter(requestData.toUseCaseModel());
        return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/api/v1/counters/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCounter(@PathVariable("id") Long id) {
        GetCounterResponse getCounterResponse = getCounter.getCounterById(id);
        return new ResponseEntity<>(new GetCounterControllerResponseData(getCounterResponse.getId(), getCounterResponse.getVillage().getName()), HttpStatus.OK);
    }

    @RequestMapping(path = "/api/v1/counters", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCounters(@RequestParam("hardDelete") boolean hardDelete) {
        deleteCounter.deleteAll(hardDelete);
        return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
    }

    @RequestMapping(path = "/api/v1/counters/{counterId}/callback", method = RequestMethod.POST)
    public ResponseEntity<?> counterConsumptionCallback(@PathVariable("counterId") Long counterId, @Valid @RequestBody LogConsumptionRequestData requestData) {
        logConsumption.logConsumption(counterId, requestData.getAmount());
        return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.CREATED);
    }
}
