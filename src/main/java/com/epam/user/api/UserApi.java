package com.epam.user.api;

import com.epam.user.controller.model.UserModel;
import com.epam.user.dto.UserDto;
import com.epam.user.dto.validation.group.OnCreate;
import com.epam.user.dto.validation.group.OnUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "user management REST API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "InternalServer Error")
})
@RequestMapping("/api/v1/user")
public interface UserApi {

    @ApiOperation("Get user API")
    @ApiResponse(code = 200, message = "OK", response = UserModel.class)
    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    UserModel getUser(@PathVariable Long userId);

    @ApiOperation("Create user API")
    @ApiResponse(code = 201, message = "Created", response = UserModel.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserModel createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto);

    @ApiOperation("Update user API")
    @ApiResponse(code = 200, message = "OK", response = UserModel.class)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    UserModel updateUser(@RequestBody @Validated(OnUpdate.class) UserDto userDto);

    @ApiOperation("Delete user API")
    @ApiResponse(code = 204, message = "OK")
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);


}
