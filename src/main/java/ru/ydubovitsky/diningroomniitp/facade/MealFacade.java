package ru.ydubovitsky.diningroomniitp.facade;

import ru.ydubovitsky.diningroomniitp.dto.MealRequestDto;
import ru.ydubovitsky.diningroomniitp.dto.MealResponseDto;
import ru.ydubovitsky.diningroomniitp.model.MealItem;

public class MealFacade {

    public static MealRequestDto mealToMealRequestDto(MealItem mealItem) {
        return MealRequestDto.builder()
                .name(mealItem.getName())
                .calories(mealItem.getCalories())
                .description(mealItem.getDescription())
                .build();
    }

    public static MealResponseDto mealToMealResponseDto(MealItem mealItem) {
        return MealResponseDto.builder()
                .id(mealItem.getId())
                .name(mealItem.getName())
                .calories(mealItem.getCalories())
                .description(mealItem.getDescription())
                .build();
    }

}
