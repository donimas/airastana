package kz.dkazi.airastana.dto.mapper;

import kz.dkazi.airastana.dto.FlightDTO;
import kz.dkazi.airastana.entity.Airport;
import kz.dkazi.airastana.entity.Flight;
import kz.dkazi.airastana.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FlightMapper implements TopMapper<Flight, FlightDTO> {

    private final AirportService airportService;

    @Override
    public Flight toEntity(FlightDTO dto) {
        Flight flight = new Flight();
        Optional<Airport> origin = airportService.findOneByCode(dto.getOriginCode());
        Optional<Airport> destination = airportService.findOneByCode(dto.getDestinationCode());
        origin.ifPresent(flight::setOrigin);
        destination.ifPresent(flight::setDestination);
        flight.setId(dto.getId());
        flight.setDeparture(dto.getDeparture());
        flight.setArrival(dto.getArrival());
        flight.setStatus(dto.getStatus());
        return flight;
    }

    @Override
    public FlightDTO toDto(Flight entity) {
        return new FlightDTO(
                entity.getId(),
                entity.getOrigin().getCode(),
                entity.getDestination().getCode(),
                entity.getDeparture(),
                entity.getArrival(),
                entity.getStatus()
        );
    }
}
