package ru.ydubovitsky.stolovaya51.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "table_mealItem")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true)
    private String name;

    private Short calories;

    private String description;

    @JsonIgnore
    @OneToOne(mappedBy = "mealItem", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false, orphanRemoval = true)
    private MenuItem menuItem;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Ingredient> ingredientSet;
}
