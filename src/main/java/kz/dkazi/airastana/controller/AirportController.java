package kz.dkazi.airastana.controller;

import kz.dkazi.airastana.dto.AirportDTO;
import kz.dkazi.airastana.service.AirportService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airport")
@AllArgsConstructor
public class AirportController {

    private final Logger log = LoggerFactory.getLogger(AirportController.class);

    private final AirportService airportService;

    @PostMapping
    public ResponseEntity<AirportDTO> createAirport(@RequestBody @Validated AirportDTO airportDTO) {
        log.info("REST request to create Airport: {}", airportDTO);
        if(airportDTO.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(airportDTO);
        }

        AirportDTO saved = airportService.create(airportDTO);
        return ResponseEntity.ok(saved);
    }

}
