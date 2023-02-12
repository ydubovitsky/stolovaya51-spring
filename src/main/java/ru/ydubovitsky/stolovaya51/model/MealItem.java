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
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true)
    private String name;

    private Short calories;

    private String description;

    @OneToOne
    @JsonIgnore
    private MenuItem menuItem;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private Set<Ingredient> ingredientSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealItem mealItem = (MealItem) o;
        return Objects.equals(id, mealItem.id) &&
                Objects.equals(name, mealItem.name) &&
                Objects.equals(calories, mealItem.calories) &&
                Objects.equals(description, mealItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, description);
    }
}
