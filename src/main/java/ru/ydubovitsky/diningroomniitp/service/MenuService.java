package ru.ydubovitsky.diningroomniitp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ydubovitsky.diningroomniitp.dto.MenuRequestDto;
import ru.ydubovitsky.diningroomniitp.facade.MenuFacade;
import ru.ydubovitsky.diningroomniitp.model.Menu;
import ru.ydubovitsky.diningroomniitp.repository.MenuRepository;

import java.sql.Date;

@Primary
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MenuService implements MenuServiceInterface {

    private final MenuRepository menuRepository;

    //!If menu entity already exists, it will update!
    public Menu saveMenu(MenuRequestDto menuRequestDto) {
        Menu menu = MenuFacade.menuRequestDtoToMenu(menuRequestDto);
        Menu menuFromDatabase = menuRepository.findByDate(menu.getDate());
        if(menuFromDatabase == null) {
            menuRepository.save(menu);
            log.info(String.format("Menu for %s saved", menu.getDate()));
            return menu;
        } else {
            return updateMenuIfExists(menu);
        }
    }

    @Override
    public Menu updateMenu(MenuRequestDto menuRequestDto) {
        return updateMenuIfExists(MenuFacade.menuRequestDtoToMenu(menuRequestDto));
    }

    //!TODO Сделать другой метод, этот прям вырви глаз плохой
    public Menu getMenuByYearMonthDay(String year, String month, String day) {
        String dateString = year + "-" + month + "-" + day;
        return menuRepository.findByDateLike(dateString);
    }

    public Menu getMenuByDate(Date date) {
        return menuRepository.findByDate(date);
    }

    private Menu updateMenuIfExists(Menu newMenu) {
        Menu menuFromDatabase = menuRepository.findByDate(newMenu.getDate());
        if(menuFromDatabase != null) {
            newMenu.setId(menuFromDatabase.getId());
            Menu savedMenu = menuRepository.save(newMenu);
            log.info(String.format("Menu for %s updated", savedMenu.getDate()));
            return savedMenu;
        } else {
            throw new RuntimeException(String.format("Menu for %s not found", newMenu.getDate()));
        }
    }

}
