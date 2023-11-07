package kz.dkazi.airastana.service;

import kz.dkazi.airastana.dto.AirportDTO;
import kz.dkazi.airastana.dto.mapper.AirportMapper;
import kz.dkazi.airastana.entity.Airport;
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

    public AirportDTO save(AirportDTO airportDTO) {
        log.debug("Request to save Airport: {}", airportDTO);
        Airport airport = airportMapper.toEntity(airportDTO);
        return airportMapper.toDto(airportRepository.save(airport));
    }

    public Optional<Airport> findOneByCode(String code) {
        log.debug("Request to find one by code: {}", code);
        return airportRepository.findOneByCode(code);
    }

}
