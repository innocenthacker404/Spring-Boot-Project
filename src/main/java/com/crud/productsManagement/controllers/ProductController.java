package com.crud.productsManagement.Controllers;

import com.crud.productsManagement.entities.Product;
import com.crud.productsManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Get a specific product from DB
    @GetMapping("{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
        Optional<Product> currentProduct = Optional.ofNullable(productService.getProduct(productId));
        if(currentProduct.isPresent()) {
            return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Get All Products from DB
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK) ;
    }

    //Create a new Product
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Update a specific product by product_id
    @PutMapping("{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long id, @RequestBody Product product){
        productService.updateProduct(product, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    //Delete a specific product by product_id
    @DeleteMapping("{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}