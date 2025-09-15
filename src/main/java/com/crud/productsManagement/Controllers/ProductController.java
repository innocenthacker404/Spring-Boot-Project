package com.crud.productsManagement.Controllers;

import com.crud.productsManagement.entities.Product;
import com.crud.productsManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Get a specific product from DB
    @GetMapping("{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        return productService.getProduct(productId);
    }

    //Get All Products from DB
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //Create a new Product
    @PostMapping()
    public String createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return "Created Successfully!";
    }

    //Update a specific product by product_id
    @PutMapping("{productId}")
    public String updateProduct(@PathVariable("productId") Long id, @RequestBody Product product){
        productService.updateProduct(product, id);
        return "Updated Successfully!";

    }

    //Delete a specific product by product_id
    @DeleteMapping("{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
        return "Deleted Successfully!";
    }
}