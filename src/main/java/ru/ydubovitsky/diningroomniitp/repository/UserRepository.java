package ru.ydubovitsky.diningroomniitp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.diningroomniitp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
