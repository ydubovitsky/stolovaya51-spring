package ru.ydubovitsky.diningroomniitp.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Table(name = "table_menu")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(unique = true)
    private Date date;

    @OneToMany(
//            TODO Разобраться с этим!
//            mappedBy = "something!",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<MenuEntity> menuEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(date, menu.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
