package ru.ydubovitsky.diningroomniitp.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.ydubovitsky.diningroomniitp.model.User;
import ru.ydubovitsky.diningroomniitp.model.enums.RoleEnum;
import ru.ydubovitsky.diningroomniitp.repository.UserRepository;
import ru.ydubovitsky.diningroomniitp.security.config.JwtConfig;

@RequiredArgsConstructor
@Slf4j
@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;

    @Override
    public void run(String... args) throws Exception {
        User admin = User.builder()
                .username(jwtConfig.getInitAdminName())
                .password(passwordEncoder.encode(jwtConfig.getInitAdminPassword()))
                .password2(passwordEncoder.encode(jwtConfig.getInitAdminPassword()))
                .role(RoleEnum.ADMIN)
                .build();
        userRepository.save(admin);
        log.info("Admin user created");
    }
}
