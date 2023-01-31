package ru.ydubovitsky.diningroomniitp.security.service;


import ru.ydubovitsky.diningroomniitp.security.model.AppUser;

public interface AppUserServiceDao  {

    AppUser getAppUserByUsername(String name);

}
