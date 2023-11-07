package kz.dkazi.airastana.repository.spec;

import kz.dkazi.airastana.entity.Flight;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

public class FlightSpec {

    public static Specification<Flight> statusIsNotNull() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("status"));
    }

    public static Specification<Flight> originCodeEqual(String originCode) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(get(root, "origin.code".split("\\.")), originCode);
    }

    public static Specification<Flight> destinationCodeEqual(String destinationCode) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(get(root, "destination.code".split("\\.")), destinationCode);
    }

    private static Path get(Path root, String[] chain) {
        Path result = root;
        for (String path : chain) {
            result = result.get(path);
        }
        return result;
    }

}
