package ru.ydubovitsky.stolovaya51.facade;

import ru.ydubovitsky.stolovaya51.dto.UserRegistrationRequestDto;
import ru.ydubovitsky.stolovaya51.dto.UserResponseDto;
import ru.ydubovitsky.stolovaya51.model.User;

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
