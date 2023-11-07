package kz.dkazi.airastana.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsDTO implements Serializable {

    @NotBlank
    @Size(max = 50)
    private String username;
    @NotBlank
    @Size(min = 4, max = 20)
    private String password;
}