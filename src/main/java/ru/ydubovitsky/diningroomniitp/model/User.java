package ru.ydubovitsky.diningroomniitp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ru.ydubovitsky.diningroomniitp.model.enums.RoleEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "user_table",
        indexes = {@Index(name = "idx_username", columnList = "username", unique = true),
                @Index(name = "idx_email", columnList = "email", unique = true)}
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(name = "username", unique = true, nullable = false, updatable = true)
    private String username;
    private String password;
    private String password2;

    @Column(unique = true, updatable = true)
    private String email;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<MenuItem> menuItems;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
