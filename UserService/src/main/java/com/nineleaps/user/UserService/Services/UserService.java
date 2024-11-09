package com.nineleaps.user.UserService.Services;

import com.nineleaps.user.UserService.Dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    UserDto getUser(String userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(String userId, UserDto userDto);

    void deleteUser(String userId);

}
