package com.epam.user.controller.assembler;

import com.epam.user.controller.UserController;
import com.epam.user.controller.model.UserModel;
import com.epam.user.dto.UserDto;
import org.springframework.hateoas.Link;//no idea if the import is correct
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public static final String GET_REL = "get";
    public static final String CREATE_REL = "create";
    public static final String UPDATE_REL = "update";
    public static final String DELETE_REL = "delete";

    public UserModelAssembler(){
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);
        Link getLink = linkTo(methodOn(UserController.class).getUser(entity.getId())).withRel(GET_REL);
        Link createLink = linkTo(methodOn(UserController.class).createUser(null)).withRel(CREATE_REL);
        Link updateLink  = linkTo(methodOn(UserController.class).updateUser(null)).withRel(UPDATE_REL);
        Link deleteLink = linkTo(methodOn(UserController.class).deleteUser(entity.getId()))
                .withRel(DELETE_REL);

        userModel.add(createLink, deleteLink, updateLink, getLink);
        return userModel;

    }
}
