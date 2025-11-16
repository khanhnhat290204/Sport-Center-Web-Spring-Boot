package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nkn.SportCenter.dto.request.UserRequest;
import com.nkn.SportCenter.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles",ignore = true)
    User toUser(UserRequest request);
}
