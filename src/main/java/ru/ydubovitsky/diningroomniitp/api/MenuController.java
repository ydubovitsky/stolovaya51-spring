package ru.ydubovitsky.diningroomniitp.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.diningroomniitp.dto.MenuRequestDto;
import ru.ydubovitsky.diningroomniitp.model.Menu;
import ru.ydubovitsky.diningroomniitp.service.MenuService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public HttpStatus addNewMenu(@RequestBody MenuRequestDto menuRequestDto) {
        menuService.createNewMenu(menuRequestDto);
        return HttpStatus.OK;
    }

    @GetMapping(params = {"day", "month", "year"})
    public ResponseEntity<?> getMenuByYearMonthDay(
            @RequestParam(value = "day") String day,
            @RequestParam(value = "month") String month,
            @RequestParam(value = "year") String year
    ) {
        List<Menu> menuByDayMonthYear = menuService.getMenuByYearMonthDay(year, month, day);
        return ResponseEntity.ok(menuByDayMonthYear);
    }

    @GetMapping(params = {"date"})
    public ResponseEntity<?> getMenuByDate(@RequestParam(value = "date") LocalDate date) {
        List<Menu> menuByDayMonthYear = menuService.getMenuByDate(Date.valueOf(date));
        return ResponseEntity.ok(menuByDayMonthYear);
    }
}
