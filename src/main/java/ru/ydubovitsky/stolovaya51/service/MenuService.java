package ru.ydubovitsky.stolovaya51.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ydubovitsky.stolovaya51.dto.MenuRequestDto;
import ru.ydubovitsky.stolovaya51.facade.MenuFacade;
import ru.ydubovitsky.stolovaya51.model.Menu;
import ru.ydubovitsky.stolovaya51.repository.MenuRepository;

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
