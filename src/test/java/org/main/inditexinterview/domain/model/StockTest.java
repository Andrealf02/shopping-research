package org.main.inditexinterview.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StockTest {

    @Test
    void createStock_ValidInput_Success() {
        Stock stock = new Stock(5, 10, 15);

        assertThat(stock.getSizeS()).isEqualTo(5);
        assertThat(stock.getSizeM()).isEqualTo(10);
        assertThat(stock.getSizeL()).isEqualTo(15);
    }

    @Test
    void createStock_NegativeSize_ExceptionThrown() {
        assertThatThrownBy(() -> new Stock(-5, 10, 15))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Stock sizes must be non-negative");
    }
}