package kz.dkazi.airastana.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDTO implements Serializable {

    @NotBlank
    @Max(value = 50)
    private String username;
    @NotBlank
    @Min(value = 4)
    @Max(value = 50)
    private String password;
}