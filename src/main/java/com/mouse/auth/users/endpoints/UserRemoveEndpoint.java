package com.mouse.auth.users.endpoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Users")
public class UserRemoveEndpoint {

    @DeleteMapping(path = "/users/{userId}")
    @Operation(operationId = "UserRemove")
    public String invoke(@PathVariable String  userId) {
        return "UserRemoveEndpoint";
    }

}
