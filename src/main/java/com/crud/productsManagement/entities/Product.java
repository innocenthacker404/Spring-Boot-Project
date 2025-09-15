package com.crud.productsManagement.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name= "products")
@Data
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long productId;

        @Column(nullable = false)
        public String productCategory;

        @Column(nullable = false)
        public String productName;

        @Column(nullable = false)
        public String productPrice;

        @Column(nullable = false)
        public String productQuantity;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(String productCategory) {
            this.productCategory = productCategory;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(String productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductQuantity() {
            return productQuantity;
        }

        public void setProductQuantity(String productQuantity) {
            this.productQuantity = productQuantity;
        }
    }
