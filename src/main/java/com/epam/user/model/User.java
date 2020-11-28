package com.epam.user.model;

import lombok.Data;
import lombok.Getter;

@Data
public class User {

    @Getter private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;


}
