package com.mouse.auth.users.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class User {
    private String username;

    private String password;

    @Nullable
    private String email;
}
