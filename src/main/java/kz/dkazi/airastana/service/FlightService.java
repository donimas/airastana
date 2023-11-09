package kz.dkazi.airastana.service;

import kz.dkazi.airastana.dto.FlightDTO;
import kz.dkazi.airastana.dto.mapper.FlightMapper;
import kz.dkazi.airastana.entity.Flight;
import kz.dkazi.airastana.enums.EventType;
import kz.dkazi.airastana.logging.LogEvent;
import kz.dkazi.airastana.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class FlightService {

    private final Logger log = LoggerFactory.getLogger(FlightService.class);

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @LogEvent(
            type = EventType.CREATE,
            template = "Добавление нового рейса: %s",
            values = true
    )
    public FlightDTO create(FlightDTO flightDTO) {
        log.info("Request to save flight: {}", flightDTO);
        if(flightDTO.getId() != null) {
            throw new RuntimeException("ID exists");
        }
        Flight flight = flightMapper.toEntity(flightDTO);
        Flight saved = flightRepository.save(flight);

        return flightMapper.toDto(saved);
    }

    @LogEvent(
            type = EventType.EDIT,
            template = "Изменения статуса рейса: %s",
            values = true
    )
    public FlightDTO updateStatus(Long id, FlightDTO flightDTO) {
        log.info("Request to update status of Flight: {} -> {}", id, flightDTO);
        Flight flight = validateFlight(id, flightDTO);
        try {
            flight.setStatus(flightDTO.getStatus());
            Flight updated = flightRepository.save(flight);
            return flightMapper.toDto(updated);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Flight validateFlight(Long id, FlightDTO flightDTO) {
        if(id == null) {
            throw new RuntimeException("id does not exist", new Throwable("id does not exist"));
        }
        if(flightDTO == null) {
            throw new RuntimeException("Flight is null");
        }
        if(flightDTO.getStatus() == null) {
            throw new RuntimeException("Status is null");
        }
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found", new Throwable("id does not exist")));
    }

}
