package org.main.inditexinterview.domain.model;

import java.util.Objects;

public class Stock {
    private final int sizeS;
    private final int sizeM;
    private final int sizeL;

    public Stock(int sizeS, int sizeM, int sizeL) {
        validateStockInput(sizeS, sizeM, sizeL);
        this.sizeS = sizeS;
        this.sizeM = sizeM;
        this.sizeL = sizeL;
    }

    private void validateStockInput(int sizeS, int sizeM, int sizeL) {
        if (sizeS < 0 || sizeM < 0 || sizeL < 0) {
            throw new IllegalArgumentException("Stock sizes must be non-negative");
        }
    }

    public int getSizeS() {
        return sizeS;
    }

    public int getSizeM() {
        return sizeM;
    }

    public int getSizeL() {
        return sizeL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return sizeS == stock.sizeS &&
                sizeM == stock.sizeM &&
                sizeL == stock.sizeL;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeS, sizeM, sizeL);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sizeS=" + sizeS +
                ", sizeM=" + sizeM +
                ", sizeL=" + sizeL +
                '}';
    }
}
