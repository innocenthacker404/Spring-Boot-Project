package com.crud.productsManagement.services.impl;

import com.crud.productsManagement.entities.Users;
import com.crud.productsManagement.repositories.UserRepository;
import com.crud.productsManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users getUser(Long id) {
        if(userRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("The user does not exist!");
        }
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUser(Users user, Long id) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
