package kz.dkazi.airastana.controller;

import kz.dkazi.airastana.dto.FlightDTO;
import kz.dkazi.airastana.service.FlightSearchService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class FlightSearchController {

    private final Logger log = LoggerFactory.getLogger(FlightSearchController.class);

    private final FlightSearchService flightSearchService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDTO>> fetchFlights(@RequestParam String originCode, @RequestParam String destinationCode) {
        log.debug("REST request to fetch flights");
        List<FlightDTO> flights = flightSearchService.getFlights(originCode, destinationCode);

        return ResponseEntity.ok(flights);
    }

}
