package org.main.inditexinterview.domain;

import org.main.inditexinterview.domain.exception.ProductValidationException;
import org.main.inditexinterview.domain.exception.StockValidationException;

import java.util.Objects;

public class Product {
    private final long id;
    private final String name;
    private final int salesUnits;
    private final Stock stock;

    public Product(long id, String name, int salesUnits, Stock stock) throws ProductValidationException, StockValidationException {
        validateInput(id, name, salesUnits, stock);
        this.id = id;
        this.name = name;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    private void validateInput(long id, String name, int salesUnits, Stock stock) throws ProductValidationException, StockValidationException {
        Objects.requireNonNull(name, "Product name cannot be null");
        if (id <= 0) {
            throw new ProductValidationException("Product id must be greater than 0");
        }
        if (salesUnits < 0) {
            throw new ProductValidationException("Sales units must be non-negative");
        }
        Objects.requireNonNull(stock, "Stock cannot be null");
        stock.validateStock();
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
