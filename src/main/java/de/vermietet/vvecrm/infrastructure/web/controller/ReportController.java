package de.vermietet.vvecrm.infrastructure.web.controller;

import de.vermietet.vvecrm.infrastructure.web.model.VillageConsumptionReportControllerResponseData;
import de.vermietet.vvecrm.usecases.GetConsumptionReport;
import de.vermietet.vvecrm.usecases.model.VillageConsumptionReportResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class ReportController {
    private final GetConsumptionReport getConsumptionReport;

    @Inject
    public ReportController(GetConsumptionReport getConsumptionReport) {
        this.getConsumptionReport = getConsumptionReport;
    }

    @RequestMapping(path = "/api/v1/reports/village/consumption", method = RequestMethod.GET)
    public ResponseEntity<?> getVillageConsumption(@RequestParam("duration") String duration) {
        System.out.println("=------------------------> " + duration);
        Collection<VillageConsumptionReportResponse> consumptionReportResponses = getConsumptionReport.getVillageConsumptionReport(duration);
        return new ResponseEntity<>(
                consumptionReportResponses
                        .stream()
                        .map((c) -> new VillageConsumptionReportControllerResponseData(c.getVillageName(), c.getConsumption().setScale(2, RoundingMode.CEILING).doubleValue()))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
}
