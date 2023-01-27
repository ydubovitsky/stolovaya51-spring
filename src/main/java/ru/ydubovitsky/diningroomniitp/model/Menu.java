package ru.ydubovitsky.diningroomniitp.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
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

    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<MenuEntity> menuEntities;

}
