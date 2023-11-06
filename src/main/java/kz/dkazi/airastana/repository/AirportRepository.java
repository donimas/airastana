package kz.dkazi.airastana.repository;

import kz.dkazi.airastana.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}