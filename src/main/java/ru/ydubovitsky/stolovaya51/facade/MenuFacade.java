package ru.ydubovitsky.stolovaya51.facade;

import ru.ydubovitsky.stolovaya51.dto.MenuRequestDto;
import ru.ydubovitsky.stolovaya51.model.Menu;

public class MenuFacade {

    public static Menu menuRequestDtoToMenu(MenuRequestDto menuRequestDto) {
        return Menu.builder()
                .date(menuRequestDto.getDate())
                .menuEntities(menuRequestDto.getMenuEntities())
                .build();
    }

}
