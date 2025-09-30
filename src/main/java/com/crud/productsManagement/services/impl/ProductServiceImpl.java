package com.crud.productsManagement.services.impl;

import com.crud.productsManagement.dtos.ProductReqDto;
import com.crud.productsManagement.dtos.ProductResDto;
import com.crud.productsManagement.entities.Product;
import com.crud.productsManagement.exceptions.ProductNotFoundException;
import com.crud.productsManagement.repositories.ProductRepository;
import com.crud.productsManagement.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

// Business Layer for ProductsManagement

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product getProduct(Long productId) {
        //More Business Logic
       return productRepository.findById(productId)
               .orElseThrow(() -> new ProductNotFoundException("Product is not found with ID: "+productId));
    }

    @Override
    public ProductResDto createProduct(ProductReqDto productReqDto) {
        //More Business Logic
        Product newProduct = modelMapper.map(productReqDto, Product.class);
        Product product = productRepository.save(newProduct);
        return modelMapper.map(product, ProductResDto.class);
    }

    @Override
    public ProductResDto updateProduct(ProductReqDto updatedProduct, Long id) {

        //More Business Logic
       Product product = productRepository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException("Product doesn't exist with ID: "+id));

       modelMapper.map(updatedProduct, product);
       product = productRepository.save(product);
       return modelMapper.map(product, ProductResDto.class);
    }

    @Override
    public void deleteProduct(Long productId) {

        //More Business Logic
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNotFoundException("The Product with id "+productId+" does not Exist!");
        }else {
            productRepository.deleteById(productId);
        }
    }

    @Override
    public List<Product> getAllProducts() {

        //More Business Logic
        return productRepository.findAll();
    }

    @Override
    public ProductResDto updatePartialProduct(Long id, Map<String, Object> updates) {
        Product product = productRepository.findById(id).
                orElseThrow(()-> new ProductNotFoundException("product does not exist with ID: "+id));

        updates.forEach((field, value) -> {
                switch(field) {
                    case "productCategory":
                        product.setProductCategory((String) value);
                        break;
                    case "productName":
                        product.setProductName((String) value);
                        break;
                    case "productQuantity":
                        product.setProductQuantity((String) value);
                        break;
                    case "productPrice":
                        product.setProductPrice((String) value);
                        break;

                    default:
                        throw new IllegalArgumentException("Field is not supported");
                }
        });
        Product newProduct = productRepository.save(product);
        return modelMapper.map(newProduct, ProductResDto.class);
    }
}