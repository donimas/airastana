package kz.dkazi.airastana.repository;

import kz.dkazi.airastana.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FlightSearchRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {


}
