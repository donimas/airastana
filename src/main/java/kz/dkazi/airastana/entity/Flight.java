package kz.dkazi.airastana.entity;

import kz.dkazi.airastana.enums.FlightStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@Data
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;

    @Column(name = "departure")
    private LocalDateTime departure;

    @Column(name = "arrival")
    private LocalDateTime arrival;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private FlightStatus status;

    public LocalDateTime getDeparture() {
        ZoneId originTimeZone = ZoneId.of(origin.getTimeZone());
        return departure.atZone(originTimeZone).toLocalDateTime();
    }

    public LocalDateTime getArrival() {
        ZoneId destinationTimeZone = ZoneId.of(destination.getTimeZone());
        return arrival.atZone(destinationTimeZone).toLocalDateTime();
    }

}
