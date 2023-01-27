package ru.ydubovitsky.diningroomniitp.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.diningroomniitp.dto.MealRequestDto;
import ru.ydubovitsky.diningroomniitp.dto.MealResponseDto;
import ru.ydubovitsky.diningroomniitp.facade.MealFacade;
import ru.ydubovitsky.diningroomniitp.model.MealItem;
import ru.ydubovitsky.diningroomniitp.service.MealService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/meal")
public class MealController {

    private final MealService mealService;

    @GetMapping("/all")
    public ResponseEntity<Set<MealResponseDto>> getAllMeals() {
        List<MealItem> allMealItems = mealService.getAllMeals();
        return ResponseEntity.ok(allMealItems
                .stream()
                .map(meal -> MealFacade.mealToMealResponseDto(meal))
                .collect(Collectors.toSet()));
    }

    @PostMapping
    public ResponseEntity<?> addNewMeal(@RequestBody MealRequestDto mealRequestDto) {
        MealItem createdMealItem = mealService.createNewMeal(mealRequestDto);
        return ResponseEntity.ok(createdMealItem);
    }
}
