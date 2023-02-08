package com.mouse.auth.users.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserChangeUsernameRequest {
    private String username;

    private String userId;
}
