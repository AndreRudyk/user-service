package com.epam.user.service;

import com.epam.user.dto.UserDto;

public interface UserService {
    UserDto getUser(Long userId);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void  deleteUser(Long userId);

    boolean isUserExistsWithEmail(String email);
}
