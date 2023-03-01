package ru.ydubovitsky.stolovaya51.security.request;

import lombok.Data;

@Data
public class UsernameAndPasswordAuthRequest {

    private String username;
    private String password;

}
