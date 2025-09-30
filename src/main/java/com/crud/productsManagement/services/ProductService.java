package com.crud.productsManagement.services;

import com.crud.productsManagement.dtos.ProductReqDto;
import com.crud.productsManagement.dtos.ProductResDto;
import com.crud.productsManagement.entities.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
        //For Create
        ProductResDto createProduct(ProductReqDto product);

        //For Read by specific id
        Product getProduct(Long productId);

        //For Update
        ProductResDto updateProduct(ProductReqDto product, Long id);

        //For Delete
        void deleteProduct(Long id);

        //For Read All
        List<Product> getAllProducts();

        //For Update Partial field
        ProductResDto updatePartialProduct(Long id, Map<String, Object> updates);
}