package com.crud.productsManagement.repositories;

import com.crud.productsManagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
