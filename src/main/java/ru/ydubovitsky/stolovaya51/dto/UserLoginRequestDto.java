package ru.ydubovitsky.stolovaya51.dto;

import lombok.*;

@Builder
@Data
@Getter @Setter
@AllArgsConstructor
public class UserLoginRequestDto {

    private String username;
    private String password;
    private String role;
}
