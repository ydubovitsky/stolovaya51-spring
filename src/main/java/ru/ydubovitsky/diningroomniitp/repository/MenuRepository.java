package ru.ydubovitsky.diningroomniitp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ydubovitsky.diningroomniitp.model.Menu;

import java.sql.Date;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Short> {

    List<Menu> findByDate(Date date);

    @Query(value = "SELECT * FROM TABLE_MENU where date like %:dateString%", nativeQuery = true)
    List<Menu> findByDateLike(String dateString);
}
