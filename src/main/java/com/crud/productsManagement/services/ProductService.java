package com.crud.productsManagement.services;

import com.crud.productsManagement.entities.Product;

import java.util.List;

    public interface ProductService {
        //For Create
        void createProduct(Product product);

        //For Read by specific id
        Product getProduct(Long productId);

        //For Update
        void updateProduct(Product product, Long id);

        //For Delete
        void deleteProduct(Long id);

        //For Read All
        List<Product> getAllProducts();
}
