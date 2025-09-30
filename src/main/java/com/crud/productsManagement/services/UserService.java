package com.crud.productsManagement.services;

import com.crud.productsManagement.dtos.AddUserDto;
import com.crud.productsManagement.dtos.UserDto;
import com.crud.productsManagement.entities.Users;

public interface UserService {

    UserDto createUser(AddUserDto user);

    UserDto getUser(Long id);

    Users updateUser(Long id, AddUserDto user);

    void deleteUser(Long id);
}