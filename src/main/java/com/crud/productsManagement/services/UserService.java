package com.crud.productsManagement.services;

import com.crud.productsManagement.dtos.AddUserDto;
import com.crud.productsManagement.dtos.UserDto;
import com.crud.productsManagement.entities.Users;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDto createUser(AddUserDto user);

    UserDto getUser(Long id);

    UserDto updateUser(Long id, AddUserDto user);

    void deleteUser(Long id);

    List<Users> getAll();

    UserDto updatePartial(Long id, Map<String, Object> updates);
}