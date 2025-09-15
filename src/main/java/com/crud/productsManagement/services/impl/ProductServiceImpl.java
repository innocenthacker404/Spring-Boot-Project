package com.crud.productsManagement.services.impl;

import com.crud.productsManagement.entities.Product;
import com.crud.productsManagement.exceptions.ProductNotFoundException;
import com.crud.productsManagement.repositories.ProductRepository;
import com.crud.productsManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product getProduct(Long productId) {
        //More Business Logic
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNotFoundException("Requested Product does not exist!");
        }
        return productRepository.findById(productId).get();
    }

    @Override
    public void createProduct(Product product) {
        //More Business Logic
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product updatedProduct, Long id) {

        //More Business Logic
        Optional<Product> existingProductOpt = productRepository.findById(id);
        if(existingProductOpt.isPresent()){
            Product existingProduct = existingProductOpt.get();
            existingProduct.setProductCategory(updatedProduct.getProductCategory());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
            productRepository.save(existingProduct);

        }else{
            throw new ProductNotFoundException("The Product of id "+id+" is not found");
        }
    }

    @Override
    public void deleteProduct(Long productId) {

        //More Business Logic
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNotFoundException("The Product of id "+productId+" does not Exist!");
        }else {
            productRepository.deleteById(productId);
        }
    }

    @Override
    public List<Product> getAllProducts() {

        //More Business Logic
        return productRepository.findAll();
    }
}