package ru.ydubovitsky.stolovaya51.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.stolovaya51.model.MealItem;

public interface MealRepository extends JpaRepository<MealItem, Short> {

}
