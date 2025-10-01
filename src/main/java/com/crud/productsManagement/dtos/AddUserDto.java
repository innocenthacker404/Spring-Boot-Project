package com.crud.productsManagement.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddUserDto {

    @NotBlank(message = "user name required")
    @Size(min = 3, max = 30, message = "name should contain minimum 3 characters and maximum 30")
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
