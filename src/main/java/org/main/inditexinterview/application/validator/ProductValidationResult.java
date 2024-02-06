package org.main.inditexinterview.application.validator;

import org.main.inditexinterview.domain.Product;

import java.util.List;

public class ProductValidationResult {
    private final Product validProduct;
    private final List<String> validationErrors;

    public ProductValidationResult(Product validProduct, List<String> validationErrors) {
        this.validProduct = validProduct;
        this.validationErrors = validationErrors;
    }

    public Product getValidProduct() {
        return validProduct;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }
}
