package com.crud.productsManagement.Controllers;

import com.crud.productsManagement.entities.Users;
import com.crud.productsManagement.services.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping()
    public String createNew(@RequestBody Users user){
        userService.createUser(user);
        return "Created Successfully!";
    }

    @GetMapping("{id}")
    public Users getById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping()
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Users> deleteUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.ACCEPTED);
    }
}
