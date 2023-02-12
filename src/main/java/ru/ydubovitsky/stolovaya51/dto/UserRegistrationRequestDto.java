package ru.ydubovitsky.stolovaya51.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationRequestDto {

    private String username;
    private String email;
    private String password;
    private String password2;
    private String role;
}
