package ru.ydubovitsky.diningroomniitp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "table_mealItem")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

//    @Column(nullable = false, unique = true)
    private String name;

    private Short calories;

    private String description;

//    @OneToMany
//    private Set<Ingredient> ingredientSet;

}
