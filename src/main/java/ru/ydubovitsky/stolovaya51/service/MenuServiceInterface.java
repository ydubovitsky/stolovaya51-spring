package ru.ydubovitsky.stolovaya51.service;

import ru.ydubovitsky.stolovaya51.dto.MenuRequestDto;
import ru.ydubovitsky.stolovaya51.model.Menu;

import java.sql.Date;

public interface MenuServiceInterface {

    Menu saveMenu(MenuRequestDto menuRequestDto);

    Menu updateMenu(MenuRequestDto menuRequestDto);

    Menu getMenuByDate(Date date);

}
