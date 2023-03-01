package ru.ydubovitsky.stolovaya51.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.stolovaya51.model.Menu;

import java.sql.Date;

public interface MenuRepository extends JpaRepository<Menu, Short> {

    Menu findByDate(Date date);

}
