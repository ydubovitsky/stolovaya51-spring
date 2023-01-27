package ru.ydubovitsky.diningroomniitp.facade;

import ru.ydubovitsky.diningroomniitp.dto.MenuRequestDto;
import ru.ydubovitsky.diningroomniitp.model.Menu;

public class MenuFacade {

    public static Menu menuRequestDtoToMenu(MenuRequestDto menuRequestDto) {
        return Menu.builder()
                .date(menuRequestDto.getDate())
                .menuEntities(menuRequestDto.getMenuEntities())
                .build();
    }

}
