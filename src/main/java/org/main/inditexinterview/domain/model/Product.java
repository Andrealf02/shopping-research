package org.main.inditexinterview.domain.model;

import java.util.Objects;

public record Product(
        long id,
        String name,
        int salesUnits,
        Stock stock
) {
    public Product {
        validateInput(id, name, salesUnits, stock);
    }

    private void validateInput(long id, String name, int salesUnits, Stock stock) {
        Objects.requireNonNull(name, "Product name cannot be null");
        if (id <= 0) {
            throw new IllegalArgumentException("Product id must be greater than 0");
        }
        if (salesUnits < 0) {
            throw new IllegalArgumentException("Sales units must be non-negative");
        }
        Objects.requireNonNull(stock, "Stock cannot be null");
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
