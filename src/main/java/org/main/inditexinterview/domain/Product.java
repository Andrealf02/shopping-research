package org.main.inditexinterview.domain;

import org.main.inditexinterview.application.validator.ProductValidationResult;
import org.main.inditexinterview.domain.exception.StockValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Product {
    private final long id;
    private final String name;
    private final int salesUnits;
    private final Stock stock;

    public Product(long id, String name, int salesUnits, Stock stock) {
        this.id = id;
        this.name = name;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    public static ProductValidationResult createProduct(long id, String name, int salesUnits, Stock stock) {
        List<String> validationErrors = new ArrayList<>();

        if (name == null) {
            validationErrors.add("Product name cannot be null");
        }

        if (id <= 0) {
            validationErrors.add("Product id must be greater than 0");
        }

        if (salesUnits < 0) {
            validationErrors.add("Sales units must be non-negative");
        }

        if (stock == null) {
            validationErrors.add("Stock cannot be null");
        } else {
            try {
                stock.validateStock();
            } catch (StockValidationException e) {
                validationErrors.add("Stock validation failed: " + e.getMessage());
            }
        }

        if (!validationErrors.isEmpty()) {
            return new ProductValidationResult(null, validationErrors);
        }

        Product validProduct = new Product(id, name, salesUnits, stock);
        return new ProductValidationResult(validProduct, Collections.emptyList());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalesUnits() {
        return salesUnits;
    }

    public Stock getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salesUnits=" + salesUnits +
                ", stock=" + stock +
                '}';
    }
}
