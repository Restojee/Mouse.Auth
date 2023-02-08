package com.mouse.auth.users.endpoints;

import com.mouse.auth.users.models.UserChangePasswordRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Users")
public class UserPasswordChangeEndpoint {

    @PutMapping(path = "/users/password")
    @Operation(operationId = "UserPasswordChange")
    public String invoke(@RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        return "UserPasswordChangeEndpoint";
    }

}
