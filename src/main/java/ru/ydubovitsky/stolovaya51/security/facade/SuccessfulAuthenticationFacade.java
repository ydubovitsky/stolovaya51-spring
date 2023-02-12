package ru.ydubovitsky.stolovaya51.security.facade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.ydubovitsky.stolovaya51.security.response.SuccessfulAuthenticationResponse;

public class SuccessfulAuthenticationFacade {

    public static String successfulAuthenticationResponseToJsonString(
            SuccessfulAuthenticationResponse successfulAuthenticationResponse
    ) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String tokenVerifierFilterResponse
                = gson.toJson(successfulAuthenticationResponse);

        return tokenVerifierFilterResponse;
    }

}
