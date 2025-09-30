package com.crud.productsManagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long productId;

    private String productCategory;

    private String productName;

    private String productPrice;

    private String productQuantity;
}