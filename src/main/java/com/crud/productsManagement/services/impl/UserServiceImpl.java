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

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(AddUserDto addUser) {
       Users newUser = modelMapper.map(addUser, Users.class);
       Users user = userRepository.save(newUser);
       return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUser(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user does not exist with ID: "+id));
        return modelMapper.map(user, UserDto.class);
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
       userRepository.findById(id)
               .orElseThrow(() -> new UserNotFoundException("User is not found with ID: "+id));

       userRepository.deleteById(id);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public UserDto getByUserName(String userName) {
        Users user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return modelMapper.map(user, UserDto.class);
    }
}