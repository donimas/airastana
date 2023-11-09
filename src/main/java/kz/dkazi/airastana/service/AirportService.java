package kz.dkazi.airastana.service;

import kz.dkazi.airastana.dto.AirportDTO;
import kz.dkazi.airastana.dto.mapper.AirportMapper;
import kz.dkazi.airastana.entity.Airport;
import kz.dkazi.airastana.enums.EventType;
import kz.dkazi.airastana.logging.LogEvent;
import kz.dkazi.airastana.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AirportService {

    private final Logger log = LoggerFactory.getLogger(AirportService.class);

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @LogEvent(
            type = EventType.CREATE,
            template = "Добавление нового Аэропорта: %s",
            values = true
    )
    public AirportDTO create(AirportDTO airportDTO) {
        log.info("Request to save Airport: {}", airportDTO);
        Airport airport = airportMapper.toEntity(airportDTO);
        return airportMapper.toDto(airportRepository.save(airport));
    }

    public Optional<Airport> findOneByCode(String code) {
        log.info("Request to find one by code: {}", code);
        return airportRepository.findOneByCode(code);
    }

}
