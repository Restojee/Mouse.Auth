package com.mouse.auth.users.endpoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Users")
public class UserGetEndpoint {

    @GetMapping(path = "/users/{userId}")
    @Operation(operationId = "UserGet")
    public String invoke(@PathVariable String userId) {
        return "UserGetEndpoint";
    }

}
