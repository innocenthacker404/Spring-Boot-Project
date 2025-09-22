package com.crud.productsManagement.services.impl;

import com.crud.productsManagement.entities.Users;
import com.crud.productsManagement.repositories.UserRepository;
import com.crud.productsManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Users updateUser(Users updatedUser, Long id) {
        Optional<Users> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            Users existUser = userOpt.get();
            existUser.setUserName(updatedUser.getUserName());
            existUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existUser);
        }else{
            throw new IllegalArgumentException("User with id "+id+" is not exists!");
        }
    }

    @Override
    public Users deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
        throw new IllegalArgumentException("User with id "+id+" is not found");
    }
}
