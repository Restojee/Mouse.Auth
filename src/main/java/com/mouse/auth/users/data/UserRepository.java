package com.mouse.auth.users.data;

import com.mouse.auth.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    public Optional<UserEntity> findUserEntityByUsername(String username);
}
