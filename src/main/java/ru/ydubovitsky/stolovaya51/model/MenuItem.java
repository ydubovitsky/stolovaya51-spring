package ru.ydubovitsky.stolovaya51.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "table_menuItem")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Short id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private MenuEntity menuEntity;

    @OneToOne
    private MealItem mealItem;

    private String portion;

    private Integer cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

}
