package com.mouse.auth.users.mappers;



import com.mouse.auth.entities.UserEntity;
import com.mouse.auth.users.models.User;
import com.mouse.auth.users.models.UserRegisterRequest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserProfile {

    public User toUserFromUserEntity(UserEntity userEntity);

    public UserEntity toUserEntityFromUser(User userEntity);

    public UserEntity toUserEntityFromUserRegisterRequest(UserRegisterRequest userRegisterRequest);

}
