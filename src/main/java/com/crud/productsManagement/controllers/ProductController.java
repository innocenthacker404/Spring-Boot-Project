package com.crud.productsManagement.controllers;

import com.crud.productsManagement.dtos.ProductReqDto;
import com.crud.productsManagement.dtos.ProductResDto;
import com.crud.productsManagement.entities.Product;
import com.crud.productsManagement.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Get a specific product from DB
    @GetMapping("get{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    //Get All Products from DB
    @GetMapping("get_all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK) ;
    }

    //Create a new Product
    @PostMapping
    public ResponseEntity<ProductResDto> createProduct(@RequestBody @Valid ProductReqDto productReqDto){
        System.out.println(productReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productReqDto));
    }

    //Update a specific product by product_id
    @PutMapping("put{productId}")
    public ResponseEntity<ProductResDto> updateProduct(@PathVariable("productId") Long id, @Valid @RequestBody ProductReqDto product){
        productService.updateProduct(product, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //Delete a specific product by product_id
    @DeleteMapping("delete{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ProductResDto> updatePartialField(@PathVariable Long id, @Valid @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(productService.updatePartialProduct(id, updates));
    }
}