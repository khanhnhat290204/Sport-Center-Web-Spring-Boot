package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;

import com.nkn.SportCenter.dto.response.UserResponse;
import com.nkn.SportCenter.entities.User;

@Mapper(componentModel="spring")
public interface UserResponseMapper {
    UserResponse toUserResponse(User user);
}
