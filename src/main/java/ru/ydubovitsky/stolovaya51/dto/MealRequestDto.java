package ru.ydubovitsky.stolovaya51.dto;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
@Builder
public class MealRequestDto {

    private String name;

    private Short calories;

    private String description;

}
