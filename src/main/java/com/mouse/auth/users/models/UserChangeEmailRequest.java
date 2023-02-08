package com.mouse.auth.users.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserChangeEmailRequest {
    private String userId;

    private String email;
}
