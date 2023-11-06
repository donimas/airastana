package kz.dkazi.airastana.repository;

import kz.dkazi.airastana.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
