package ru.ydubovitsky.stolovaya51.facade;

import ru.ydubovitsky.stolovaya51.dto.MealRequestDto;
import ru.ydubovitsky.stolovaya51.dto.MealResponseDto;
import ru.ydubovitsky.stolovaya51.model.MealItem;

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
