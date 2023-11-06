package kz.dkazi.airastana.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CredentialsDTO implements Serializable {
    private String username;
    private String password;
}