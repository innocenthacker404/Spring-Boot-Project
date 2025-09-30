package com.crud.productsManagement.dtos;

import lombok.Data;

@Data
public class AddProductDto {

    private String productCategory;

    private String productName;

    private String productPrice;

    private String productQuantity;
}
