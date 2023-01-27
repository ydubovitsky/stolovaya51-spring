package ru.ydubovitsky.diningroomniitp.dto;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
@Builder
public class MealRequestDto {

    private String name;

    private Short calories;

    private String description;

}
