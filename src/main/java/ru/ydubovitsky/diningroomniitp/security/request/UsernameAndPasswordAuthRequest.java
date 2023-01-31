package ru.ydubovitsky.diningroomniitp.security.request;

import lombok.Data;

@Data
public class UsernameAndPasswordAuthRequest {

    private String username;
    private String password;

}
