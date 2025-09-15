package com.crud.productsManagement.exceptions;

import org.springframework.http.HttpStatus;

public record ProductException(String message, Throwable throwable, HttpStatus httpStatus) {
}
