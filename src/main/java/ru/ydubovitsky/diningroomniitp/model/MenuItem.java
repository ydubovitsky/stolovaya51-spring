package ru.ydubovitsky.diningroomniitp.model;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.MERGE)
    private MealItem mealItem;

    private String portion;

    private Integer cost;

}
