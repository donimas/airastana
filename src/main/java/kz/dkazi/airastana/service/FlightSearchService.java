package kz.dkazi.airastana.service;

import kz.dkazi.airastana.dto.FlightDTO;
import kz.dkazi.airastana.dto.mapper.FlightMapper;
import kz.dkazi.airastana.entity.Flight;
import kz.dkazi.airastana.repository.FlightSearchRepository;
import kz.dkazi.airastana.repository.spec.FlightSpec;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightSearchService {

    private final Logger log = LoggerFactory.getLogger(FlightSearchService.class);

    private final FlightSearchRepository flightSearchRepository;
    private final FlightMapper flightMapper;

    @Transactional(readOnly = true)
    public List<FlightDTO> getFlights(String originCode, String destinationCode) {
        log.debug("Request to find all Flights by originCode and destinationCode: {} -> {}", originCode, destinationCode);
        Specification<Flight> flightSpec = buildFlightSpecification(originCode, destinationCode);
        Sort sort = Sort.by("arrival");

        return flightSearchRepository.findAll(flightSpec, sort)
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    private Specification<Flight> buildFlightSpecification(String originCode, String destinationCode) {
        Specification<Flight> where = Specification.where(FlightSpec.statusIsNotNull());
        if(StringUtils.isNotBlank(originCode)) {
            where.and(FlightSpec.originCodeEqual(originCode));
        }
        if(StringUtils.isNotBlank(destinationCode)) {
            where.and(FlightSpec.destinationCodeEqual(destinationCode));
        }
        return where;
    }

}