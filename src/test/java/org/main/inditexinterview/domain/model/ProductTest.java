package org.main.inditexinterview.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ProductTest {
    @Test
    void createProduct_ValidInput_Success() {
        Stock stock = new Stock(5, 10, 15);
        Product product = new Product(1, "TestProduct", 20, stock);

        assertThat(product.id()).isEqualTo(1);
        assertThat(product.name()).isEqualTo("TestProduct");
        assertThat(product.salesUnits()).isEqualTo(20);
        assertThat(product.stock()).isEqualTo(stock);
    }

    @Test
    void createProduct_NullName_ExceptionThrown() {
        assertThatThrownBy(() -> new Product(1, null, 20, new Stock(5, 10, 15)))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Product name cannot be null");
    }

    @Test
    void createProduct_NegativeSalesUnits_ExceptionThrown() {
        assertThatThrownBy(() -> new Product(1, "TestProduct", -5, new Stock(5, 10, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Sales units must be non-negative");
    }

    @Test
    void createProduct_NullStock_ExceptionThrown() {
        assertThatThrownBy(() -> new Product(1, "TestProduct", 20, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Stock cannot be null");
    }
}