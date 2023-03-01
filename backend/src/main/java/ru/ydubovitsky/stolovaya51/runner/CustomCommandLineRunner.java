package ru.ydubovitsky.stolovaya51.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.ydubovitsky.stolovaya51.model.User;
import ru.ydubovitsky.stolovaya51.model.enums.RoleEnum;
import ru.ydubovitsky.stolovaya51.repository.UserRepository;
import ru.ydubovitsky.stolovaya51.security.config.JwtConfig;

@RequiredArgsConstructor
@Slf4j
@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;

    @Override
    public void run(String... args) throws Exception {
        userRepository.findByUsername(jwtConfig.getInitAdminName())
                .ifPresentOrElse(
                        user -> log.info("Admin exists already"),
                        this::createAdminUserOnStartup);
    }

    private void createAdminUserOnStartup() {
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
