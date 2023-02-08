package com.mouse.auth.users.endpoints;


import com.mouse.auth.users.actions.GetUsersAction;
import com.mouse.auth.users.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Tag(name = "Users")
public class UsersGetEndpoint {

    private final GetUsersAction getUsersAction;

    public UsersGetEndpoint(GetUsersAction getUsersAction) {
        this.getUsersAction = getUsersAction;
    }

    @GetMapping(path = "/users")
    @Operation(operationId = "UsersGet")
    public Collection<User> invoke()
    {
        return this.getUsersAction.invoke();
    }

}
