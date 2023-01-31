package ru.ydubovitsky.diningroomniitp.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SuccessfulAuthenticationResponse {

    private String token;
    private String username;
    private List<String> role;
}
