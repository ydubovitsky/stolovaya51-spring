package ru.ydubovitsky.diningroomniitp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "table_menuEntity")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;


}
