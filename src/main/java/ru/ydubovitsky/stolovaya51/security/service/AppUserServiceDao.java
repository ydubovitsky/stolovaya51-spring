package ru.ydubovitsky.stolovaya51.security.service;


import ru.ydubovitsky.stolovaya51.security.model.AppUser;

public interface AppUserServiceDao  {

    AppUser getAppUserByUsername(String name);

}
