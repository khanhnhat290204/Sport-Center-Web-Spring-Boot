package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;

import com.nkn.SportCenter.dto.request.UserRequest;
import com.nkn.SportCenter.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);
}
