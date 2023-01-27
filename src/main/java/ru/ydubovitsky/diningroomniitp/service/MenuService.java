package ru.ydubovitsky.diningroomniitp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ydubovitsky.diningroomniitp.dto.MenuRequestDto;
import ru.ydubovitsky.diningroomniitp.facade.MenuFacade;
import ru.ydubovitsky.diningroomniitp.model.Menu;
import ru.ydubovitsky.diningroomniitp.repository.MenuRepository;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu createNewMenu(MenuRequestDto menuRequestDto) {
        Menu menu = MenuFacade.menuRequestDtoToMenu(menuRequestDto);
        menuRepository.save(menu);
        log.info(String.format("Menu for %s saved", menu.getDate()));
        return menu;
    }

    //!TODO Сделать другой метод, этот прям вырви глаз плохой
    public List<Menu> getMenuByYearMonthDay(String year, String month, String day) {
        String dateString = year + "-" + month + "-" + day;
        return menuRepository.findByDateLike(dateString);
    }

    public List<Menu> getMenuByDate(Date date) {
        return menuRepository.findByDate(date);
    }

}
