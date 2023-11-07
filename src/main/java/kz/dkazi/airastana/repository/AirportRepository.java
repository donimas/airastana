package kz.dkazi.airastana.repository;

import kz.dkazi.airastana.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findOneByCode(String code);
}