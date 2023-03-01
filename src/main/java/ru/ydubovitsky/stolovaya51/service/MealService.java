package ru.ydubovitsky.stolovaya51.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ydubovitsky.stolovaya51.dto.MealRequestDto;
import ru.ydubovitsky.stolovaya51.model.MealItem;
import ru.ydubovitsky.stolovaya51.repository.MealRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MealService {

    private final MealRepository mealRepository;

    public List<MealItem> getAllMeals() {
        return mealRepository.findAll();
    }

    public MealItem createNewMeal(MealRequestDto mealRequestDto) {
        MealItem savedMealItem = mealRepository.save(
                MealItem.builder()
                        .name(mealRequestDto.getName())
                        .calories(mealRequestDto.getCalories())
                        .description(mealRequestDto.getDescription())
                        .build()
        );
        log.info(String.format("New meal with name %s saved", mealRequestDto.getName()));
        return savedMealItem;
    }
}
