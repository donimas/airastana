package kz.dkazi.airastana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {

    private Long id;
    private String username;
    private String roleCode;

}
