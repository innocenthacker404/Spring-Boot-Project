package com.crud.productsManagement.services.impl;

import com.crud.productsManagement.dtos.AddUserDto;
import com.crud.productsManagement.dtos.UserDto;
import com.crud.productsManagement.entities.Users;
import com.crud.productsManagement.exceptions.UserNotFoundException;
import com.crud.productsManagement.repositories.UserRepository;
import com.crud.productsManagement.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapperModel;

    @Override
    public UserDto createUser(AddUserDto addUser) {
       Users newUser = mapperModel.map(addUser, Users.class);
       Users user = userRepository.save(newUser);
       return mapperModel.map(user, UserDto.class);
    }

    @Override
    public UserDto getUser(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user does not exist with ID: "+id));
        return mapperModel.map(user, UserDto.class);
    }

    @Override
    public Users updateUser(Long id, AddUserDto updatedUser) {
        Optional<Users> userOpt = userRepository.findById(id);
        if(userOpt.isPresent()){
            Users existUser = userOpt.get();
            existUser.setUserName(updatedUser.getUserName());
            existUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existUser);
        }else{
            throw new UserNotFoundException("User with id "+id+" does not exist!");
        }
    }

    @Override
    public void deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
        throw new UserNotFoundException("User with id "+id+" is not found");
    }
}