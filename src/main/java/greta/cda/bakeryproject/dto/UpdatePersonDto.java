package greta.cda.bakeryproject.dto;

import lombok.Data;

@Data
public class UpdatePersonDto {
    private String login;
    private String password;
    private String email;
}
