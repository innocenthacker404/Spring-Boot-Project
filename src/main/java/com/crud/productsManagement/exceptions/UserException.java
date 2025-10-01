package com.crud.productsManagement.exceptions;

import org.springframework.http.HttpStatus;

public record UserException(String message, Throwable throwable, HttpStatus httpStatus) {
}
