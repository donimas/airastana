package kz.dkazi.airastana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportDTO {

    private Long id;
    @NotBlank
    @Min(value = 3)
    @Max(value = 10)
    private String code;
    @NotBlank
    @Max(value = 50)
    private String name;
    @NotBlank
    @Max(value = 200)
    private String location;
    @NotBlank
    private String timeZone;

}
