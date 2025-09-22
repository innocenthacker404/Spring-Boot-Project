package com.crud.productsManagement.repositories;

import com.crud.productsManagement.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String username);
}
