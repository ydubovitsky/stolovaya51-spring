package ru.ydubovitsky.diningroomniitp.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
public class UserUpdateRequestDto {

    private String username;
    private String password;
    private String password2;
    private String email;
    private String role;
}
