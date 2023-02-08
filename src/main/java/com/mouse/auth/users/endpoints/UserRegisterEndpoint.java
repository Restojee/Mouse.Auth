package com.mouse.auth.users.endpoints;

import com.mouse.auth.users.actions.RegisterUserAction;
import com.mouse.auth.users.models.UserRegisterRequest;
import com.mouse.auth.users.services.DefaultUserDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Users")
public class UserRegisterEndpoint {

    private final RegisterUserAction registerUserAction;

    public UserRegisterEndpoint(RegisterUserAction registerUserAction) {
        this.registerUserAction = registerUserAction;
    }

    @PostMapping(path = "/users/register")
    @Operation(operationId = "UserRegister")
    public UserDetails invoke(@RequestBody UserRegisterRequest userRegisterRequest) {
        return this.registerUserAction.invoke(userRegisterRequest);
    }

}
