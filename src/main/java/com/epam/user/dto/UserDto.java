package com.epam.user.dto;

import com.epam.user.dto.validation.UniqueEmail;
import com.epam.user.dto.validation.group.OnCreate;
import com.epam.user.dto.validation.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
public class UserDto {

    @Null(groups = OnCreate.class, message = "{id.not.null}")
    @NotNull(groups = OnUpdate.class, message = "{id.null}")
    private Long id;

    @NotBlank(groups = OnCreate.class, message = "{name.blank}")
    private String name;

    @NotBlank(groups = OnCreate.class, message = "{surname.blank}")
    private String surname;

    @Null(groups = OnUpdate.class, message = "{password.not.null}")
    @NotBlank(groups = OnCreate.class, message = "{password.blank}")
    private String password;

    @JsonProperty(access = WRITE_ONLY)
    @Null(groups = OnUpdate.class, message = "{repeatPassword.not.null}")
    @NotBlank(groups = OnCreate.class, message = "{repeatPassword.blank}")
    private String repeatPassword;

    @ApiModelProperty(notes = "Unique user's email")
    @NotBlank(message = "{email.blank}")
    @Email(message = "{email.wrong.format}")
    @UniqueEmail
    private String email;
}
