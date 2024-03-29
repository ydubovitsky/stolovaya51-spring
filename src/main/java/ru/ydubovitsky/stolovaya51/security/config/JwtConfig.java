package ru.ydubovitsky.stolovaya51.security.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import ru.ydubovitsky.stolovaya51.utils.ApplicationVariablesUtils;

@NoArgsConstructor
@Getter @Setter
@Configuration
public class JwtConfig {

    @Value("${application.jwt.securityKey}")
    private String securityKey;

    @Value("${application.jwt.tokenPrefix}")
    private String tokenPrefix;

    @Value("${application.admin.name}")
    private String initAdminName;

    @Value("${application.admin.password}")
    private String initAdminPassword;

    @Getter(AccessLevel.NONE)
    @Value("${application.cors.allowedOriginsArray}")
    private String allowedOriginsArray;

    public String[] getAllowedOriginsArray() {
        return ApplicationVariablesUtils.splitStringToArrayByPattern(allowedOriginsArray);
    }

}
