package ru.ydubovitsky.stolovaya51.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private MealItem mealItem;

}
