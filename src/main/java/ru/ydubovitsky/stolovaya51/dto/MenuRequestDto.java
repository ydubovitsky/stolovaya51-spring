package ru.ydubovitsky.stolovaya51.dto;

import lombok.*;
import ru.ydubovitsky.stolovaya51.model.MenuEntity;

import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class MenuRequestDto {

    private Short id;
    private Date date;
    private Set<MenuEntity> menuEntities;

}
