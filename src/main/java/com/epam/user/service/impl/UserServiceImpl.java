package com.epam.user.service.impl;

import com.epam.user.dto.UserDto;
import com.epam.user.exception.UserNotFoundException;
import com.epam.user.model.User;
import com.epam.user.repository.UserRepository;
import com.epam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User was not found"));
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        log.info("About to create a new user {}", user);
        user = userRepository.create(user);
        log.info("User with id {} successfully created", user.getId());
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean isUserExistsWithEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    private User mapUserDtoToUser(UserDto userDto){
        log.debug("mapUserDtoToUser: map to User from UserDto: {}", userDto);
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    private UserDto mapUserToUserDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setPassword(null);
        log.debug("mapUserToUserDto: map from User to UserDto: {}", userDto);
        return userDto;
    }
}
