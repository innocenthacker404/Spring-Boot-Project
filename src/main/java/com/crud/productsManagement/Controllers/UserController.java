package com.crud.productsManagement.Controllers;

import com.crud.productsManagement.entities.Users;
import com.crud.productsManagement.services.UserService;
import com.crud.productsManagement.services.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
}
