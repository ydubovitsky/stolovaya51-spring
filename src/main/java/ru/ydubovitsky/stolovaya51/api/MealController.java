package ru.ydubovitsky.stolovaya51.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.stolovaya51.dto.MealRequestDto;
import ru.ydubovitsky.stolovaya51.dto.MealResponseDto;
import ru.ydubovitsky.stolovaya51.facade.MealFacade;
import ru.ydubovitsky.stolovaya51.model.MealItem;
import ru.ydubovitsky.stolovaya51.service.MealService;

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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SUPER_ADMIN', 'OWNER')")
    public ResponseEntity<?> addNewMeal(@RequestBody MealRequestDto mealRequestDto) {
        MealItem createdMealItem = mealService.createNewMeal(mealRequestDto);
        return ResponseEntity.ok(createdMealItem);
    }
}
