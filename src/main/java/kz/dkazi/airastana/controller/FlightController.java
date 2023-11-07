package kz.dkazi.airastana.controller;

import kz.dkazi.airastana.dto.FlightDTO;
import kz.dkazi.airastana.service.FlightService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FlightController {

    private final Logger log = LoggerFactory.getLogger(FlightController.class);

    private final FlightService flightService;

    @PostMapping("/flight")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDTO) {
        log.info("REST request to create Flight: {}", flightDTO);
        FlightDTO saved = flightService.save(flightDTO);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/flight/{id}")
    public ResponseEntity<FlightDTO> updateStatus(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        log.info("REST request to update status of Flight: {}", flightDTO);
        FlightDTO updated = flightService.updateStatus(id, flightDTO);

        return ResponseEntity.ok(updated);
    }

}
