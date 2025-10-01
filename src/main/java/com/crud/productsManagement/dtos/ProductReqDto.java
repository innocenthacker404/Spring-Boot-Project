package com.crud.productsManagement.dtos;

import jakarta.validation.constraints.NotNull;

public class ProductReqDto {

    @NotNull
    private String productCategory;

    @NotNull
    private String productName;

    @NotNull
    private String productPrice;

    @NotNull
    private String productQuantity;

    public @NotNull String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(@NotNull String productCategory) {
        this.productCategory = productCategory;
    }

    public @NotNull String getProductName() {
        return productName;
    }

    public void setProductName(@NotNull String productName) {
        this.productName = productName;
    }

    public @NotNull String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(@NotNull String productPrice) {
        this.productPrice = productPrice;
    }

    public @NotNull String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(@NotNull String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
