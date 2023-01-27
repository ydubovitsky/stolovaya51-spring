package ru.ydubovitsky.diningroomniitp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.diningroomniitp.model.MealItem;

public interface MealRepository extends JpaRepository<MealItem, Short> {

}
