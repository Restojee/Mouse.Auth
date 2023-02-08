package com.mouse.auth.users.actions;

import com.mouse.auth.entities.UserEntity;
import com.mouse.auth.users.data.UserRepository;
import com.mouse.auth.users.models.UserRegisterRequest;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.web.client.HttpClientErrorException.*;

/* */
@Component
public class RegisterUserAction {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public RegisterUserAction(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDetails invoke(UserRegisterRequest request) throws BadRequest {
        val isUsernameFound = this.userRepository
            .findUserEntityByUsername(request.getUsername())
            .isPresent();

        if (isUsernameFound) {
            throw new ErrorResponseException(HttpStatus.BAD_REQUEST);
        }

        val passwordHash = this.passwordEncoder.encode(request.getPassword());

        return this.userRepository.save(
            UserEntity
                .builder()
                .username(request.getUsername())
                .password(passwordHash)
                .build()
        );
    }
}
