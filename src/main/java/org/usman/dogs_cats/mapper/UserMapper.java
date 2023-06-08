package org.usman.dogs_cats.mapper;

import org.mapstruct.Mapper;
import org.usman.dogs_cats.dto.UserDto;
import org.usman.dogs_cats.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User>{
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
