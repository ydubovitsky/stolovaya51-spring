package ru.ydubovitsky.diningroomniitp.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "table_ingredient")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

}
