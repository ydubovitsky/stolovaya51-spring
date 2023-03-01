package ru.ydubovitsky.stolovaya51.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String role;
}
