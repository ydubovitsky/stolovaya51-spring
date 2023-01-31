package ru.ydubovitsky.diningroomniitp.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.ydubovitsky.diningroomniitp.security.filter.JwtTokenVerifierFilter;
import ru.ydubovitsky.diningroomniitp.security.filter.JwtUsernameAndPasswordAuthFilter;

@Configuration
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

}
