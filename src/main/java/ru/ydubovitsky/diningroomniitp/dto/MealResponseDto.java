package ru.ydubovitsky.diningroomniitp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class MealResponseDto {

    private Short id;

    private String name;

    private Short calories;

    private String description;

}
