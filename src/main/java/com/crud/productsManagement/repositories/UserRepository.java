package com.crud.productsManagement.repositories;

import com.crud.productsManagement.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String username);
}
