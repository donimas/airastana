package kz.dkazi.airastana.dto.mapper;

import kz.dkazi.airastana.dto.AirportDTO;
import kz.dkazi.airastana.entity.Airport;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper implements TopMapper<Airport, AirportDTO> {

    @Override
    public Airport toEntity(AirportDTO dto) {
        Airport entity = new Airport();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setTimeZone(dto.getTimeZone());
        return entity;
    }

    @Override
    public AirportDTO toDto(Airport entity) {
        return new AirportDTO(
                entity.getId(), entity.getCode(),
                entity.getName(), entity.getLocation(),
                entity.getTimeZone()
        );
    }
}
