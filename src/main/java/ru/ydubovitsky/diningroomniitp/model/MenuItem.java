package ru.ydubovitsky.diningroomniitp.model;

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
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Short id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private MenuEntity menuEntity;

    @OneToOne
    private MealItem mealItem;

    private String portion;

    private Integer cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(id, menuItem.id) &&
                Objects.equals(portion, menuItem.portion) &&
                Objects.equals(cost, menuItem.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, portion, cost);
    }
}
