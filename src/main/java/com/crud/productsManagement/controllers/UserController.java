package com.crud.productsManagement.controllers;

import com.crud.productsManagement.dtos.AddUserDto;
import com.crud.productsManagement.dtos.UserDto;
import com.crud.productsManagement.entities.Users;
import com.crud.productsManagement.services.UserService;

import com.crud.productsManagement.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDto> createNew(@Valid @RequestBody AddUserDto user){
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("put/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @Valid @RequestBody AddUserDto user){
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("getBy")
    public ResponseEntity<UserDto> getUserByUserName(@RequestParam String name){
        return ResponseEntity.ok(userService.getByUserName(name));
    }
}