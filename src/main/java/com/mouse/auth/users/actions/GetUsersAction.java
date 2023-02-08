package com.mouse.auth.users.actions;

import com.mouse.auth.users.data.UserRepository;
import com.mouse.auth.users.mappers.UserProfile;
import com.mouse.auth.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetUsersAction {
    final UserRepository userRepository;

    final UserProfile userProfile;

    public GetUsersAction(UserRepository userRepository, UserProfile userProfile) {
        this.userRepository = userRepository;
        this.userProfile = userProfile;
    }

    public Collection<User> invoke() {
        return this.userRepository
            .findAll()
            .stream()
            .map(this.userProfile::toUserFromUserEntity)
            .collect(Collectors.toList());
    }
}
