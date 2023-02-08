package com.mouse.auth.users.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest {
    private String username;

    private String password;

    private String email;
}
