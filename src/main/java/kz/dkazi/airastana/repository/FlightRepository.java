package kz.dkazi.airastana.repository;

import kz.dkazi.airastana.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {


}
