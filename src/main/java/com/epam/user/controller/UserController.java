package com.epam.user.controller;

import com.epam.user.api.UserApi;
import com.epam.user.controller.assembler.UserModelAssembler;
import com.epam.user.controller.model.UserModel;
import com.epam.user.dto.UserDto;
import com.epam.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserModelAssembler modelAssembler;

    @Override
    public UserModel getUser(Long id) {
        log.info("getUser: with id {}", id);
        UserDto user = userService.getUser(id);
        return modelAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        log.info("deleteUser: input user id {}", id);
        userService.deleteUser(id);
    }

    @Override
    public UserModel updateUser(UserDto userDto) {
        log.info("updateUser controller is cancelled");
        UserDto user = userService.updateUser(userDto);
        return modelAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("createUser controller is cancelled");
        UserDto user = userService.createUser(userDto);
        return modelAssembler.toModel(user);
    }

//    @Override
//    public UserModel getUser(Long id){
//        log.info("getUser: with id {}", id);
//        UserDto user = userService.getUser(id);
//        return modelAssembler.toModel(user);
//    }
//
//    @Override
//    public UserModel createUser(UserDto userDto){
//        log.info("createUser controller is cancelled");
//        UserDto user = userService.createUser(userDto);
//        return modelAssembler.toModel(user);
//    }
//
//    @Override
//    public UserModel updateUser(UserDto userDto){
//        log.info("updateUser controller is cancelled");
//        UserDto user = userService.updateUser(userDto);
//        return modelAssembler.toModel(user);
//    }
//
//    @Override
//    public ResponseEntity<Void> deleteUser(Long id){
//        log.info("deleteUser: input user id {}", id);
//        userService.deleteUser(id);
//
//    }


}
