package kz.dkazi.airastana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, max = 10)
    private String code;
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 200)
    private String location;
    @NotBlank
    private String timeZone;

}
