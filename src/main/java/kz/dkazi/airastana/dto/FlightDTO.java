package kz.dkazi.airastana.dto;

import kz.dkazi.airastana.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightDTO {

    private Long id;
    @NotBlank
    private String originCode;
    @NotBlank
    private String destinationCode;
    @NotNull
    private LocalDateTime departure;
    @NotNull
    private LocalDateTime arrival;
    @NotNull
    private FlightStatus status;

}
