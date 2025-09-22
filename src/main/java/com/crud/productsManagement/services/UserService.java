package com.crud.productsManagement.services;

import com.crud.productsManagement.entities.Users;

public interface UserService {
    void createUser(Users user);

    Users getUser(Long id);

    void updateUser(Users user, Long id);

    void deleteUser(Long id);
}
