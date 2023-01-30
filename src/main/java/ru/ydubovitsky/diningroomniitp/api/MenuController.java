package ru.ydubovitsky.diningroomniitp.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.diningroomniitp.dto.MenuRequestDto;
import ru.ydubovitsky.diningroomniitp.model.Menu;
import ru.ydubovitsky.diningroomniitp.service.MenuServiceInterface;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuServiceInterface menuService;

    @PostMapping
    public HttpStatus addNewMenu(@RequestBody MenuRequestDto menuRequestDto) {
        menuService.saveMenu(menuRequestDto);
        return HttpStatus.OK;
    }

    @PutMapping
    public ResponseEntity<?> updateMenu(@RequestBody MenuRequestDto menuRequestDto) {
        Menu menu = menuService.updateMenu(menuRequestDto);
        return ResponseEntity.ok(menu);
    }

    @GetMapping(params = {"day", "month", "year"})
    public ResponseEntity<?> getMenuByYearMonthDay(
            @RequestParam(value = "day") String day,
            @RequestParam(value = "month") String month,
            @RequestParam(value = "year") String year
    ) {
        Menu menuByDayMonthYear = menuService.getMenuByYearMonthDay(year, month, day);
        return ResponseEntity.ok(menuByDayMonthYear);
    }

    @GetMapping(params = {"date"})
    public ResponseEntity<?> getMenuByDate(@RequestParam(value = "date") LocalDate date) {
        Menu menuByDayMonthYear = menuService.getMenuByDate(Date.valueOf(date));
        return ResponseEntity.ok(menuByDayMonthYear);
    }
}
