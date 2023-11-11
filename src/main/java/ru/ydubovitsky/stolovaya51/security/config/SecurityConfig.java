package ru.ydubovitsky.stolovaya51.security.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.ydubovitsky.stolovaya51.security.filter.JwtTokenVerifierFilter;
import ru.ydubovitsky.stolovaya51.security.filter.JwtUsernameAndPasswordAuthFilter;

@Slf4j
@Configuration
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private final JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //! Проблема в том, что эти два фильтра не управляются спрингом, т.к. мы создали их через new()
        http.addFilter(new JwtUsernameAndPasswordAuthFilter(authenticationManager(), jwtConfig));
        http.addFilterAfter(new JwtTokenVerifierFilter(jwtConfig), JwtUsernameAndPasswordAuthFilter.class);
    }

    //https://sysout.ru/nastrojka-cors-v-spring-security/
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        log.info(String.format("CORS AllowedOrigins %s", jwtConfig.getAllowedOriginsArray()));
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(jwtConfig.getAllowedOriginsArray())
                        .allowedMethods("*");
            }
        };
    }

}
