package ru.ydubovitsky.diningroomniitp.facade;

import ru.ydubovitsky.diningroomniitp.dto.UserRegistrationRequestDto;
import ru.ydubovitsky.diningroomniitp.dto.UserResponseDto;
import ru.ydubovitsky.diningroomniitp.model.User;

public class UserFacade {

    public static User userRegistrationDtoToUser(UserRegistrationRequestDto userRegistrationRequestDto) {
        return User.builder()
                .username(userRegistrationRequestDto.getUsername())
                .password(userRegistrationRequestDto.getPassword())
                .password2(userRegistrationRequestDto.getPassword2())
                .email(userRegistrationRequestDto.getEmail())
                .build();
    }

    public static UserResponseDto userToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }


}
