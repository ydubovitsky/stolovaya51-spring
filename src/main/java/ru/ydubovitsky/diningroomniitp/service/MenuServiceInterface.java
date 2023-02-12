package ru.ydubovitsky.diningroomniitp.service;

import ru.ydubovitsky.diningroomniitp.dto.MenuRequestDto;
import ru.ydubovitsky.diningroomniitp.model.Menu;

import java.sql.Date;

public interface MenuServiceInterface {

    Menu saveMenu(MenuRequestDto menuRequestDto);

    Menu updateMenu(MenuRequestDto menuRequestDto);

    Menu getMenuByDate(Date date);

}
