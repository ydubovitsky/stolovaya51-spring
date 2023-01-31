package ru.ydubovitsky.diningroomniitp.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.diningroomniitp.model.User;
import ru.ydubovitsky.diningroomniitp.security.model.AppUser;
import ru.ydubovitsky.diningroomniitp.service.UserService;

import java.util.List;

@Service("database")
@AllArgsConstructor
public class UserDetailsServiceDatabaseImpl implements AppUserServiceDao {

    private final UserService userService;

    @Override
    public AppUser getAppUserByUsername(String username) throws UsernameNotFoundException {
        User databaseUser = userService.getUserByUsername(username);

        AppUser appUser = AppUser.builder()
                .username(databaseUser.getUsername())
                .password(databaseUser.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(databaseUser.getRole().name())))
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();

        return appUser;
    }
}
