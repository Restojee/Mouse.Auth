package com.mouse.auth.users.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserChangePasswordRequest {
    private String userId;

    private String password;
}
