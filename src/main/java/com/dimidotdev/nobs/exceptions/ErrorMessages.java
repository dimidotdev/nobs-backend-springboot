package com.dimidotdev.nobs.exceptions;

public enum ErrorMessages {

    PRODUCT_NOT_FOUND("Product not found"),
    PRODUCT_ALREADY_EXISTS("Product already exists"),
    PRODUCT_NAME_REQUIRED("Product name is required"),
    PRODUCT_PRICE_REQUIRED("Product price is required"),
    PRODUCT_DESCRIPTION_REQUIRED("Product description is required"),
    PRODUCT_CATEGORY_REQUIRED("Product category is required"),
    PRODUCT_ID_REQUIRED("Product id is required"),
    PRODUCT_NOT_FOUND_BY_ID("Product not found by id"),
    PRODUCT_NOT_FOUND_BY_NAME("Product not found by name"),
    PRODUCT_NOT_FOUND_BY_CATEGORY("Product not found by category"),
    PRODUCT_NOT_FOUND_BY_PRICE("Product not found by price"),
    PRODUCT_NOT_FOUND_BY_DESCRIPTION("Product not found by description"),
    PRODUCT_NOT_FOUND_BY_NAME_AND_CATEGORY("Product not found by name and category"),
    PRODUCT_NOT_FOUND_BY_NAME_AND_PRICE("Product not found by name and price"),
    PRODUCT_NOT_FOUND_BY_NAME_AND_DESCRIPTION("Product not found by name and description"),
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
