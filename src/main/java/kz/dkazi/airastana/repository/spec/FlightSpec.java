package kz.dkazi.airastana.repository.spec;

import kz.dkazi.airastana.entity.Flight;
import org.springframework.data.jpa.domain.Specification;

public class FlightSpec {

    public static Specification<Flight> statusIsNotNull() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("status"));
    }

    public static Specification<Flight> originCodeEqual(String originCode) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("origin.code"), originCode);
    }

    public static Specification<Flight> destinationCodeEqual(String destinationCode) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("destination.code"), destinationCode);
    }

}
