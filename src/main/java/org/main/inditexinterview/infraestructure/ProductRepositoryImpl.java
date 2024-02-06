package org.main.inditexinterview.infraestructure;

import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.Stock;
import org.main.inditexinterview.domain.exception.StockValidationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> products;

    public ProductRepositoryImpl() throws StockValidationException {
        this.products = new ArrayList<>();
        products.add(new Product(1, "V-NECK BASIC SHIRT", 100, new Stock(4, 9, 0)));
        products.add(new Product(2, "CONTRASTING FABRIC T-SHIRT", 50, new Stock(35, 9, 9)));
        products.add(new Product(3, "RAISED PRINT T-SHIRT", 80, new Stock(20, 2, 20)));
        products.add(new Product(4, "PLEATED T-SHIRT", 3, new Stock(25, 30, 10)));
        products.add(new Product(5, "CONTRASTING LACE T-SHIRT", 650, new Stock(0, 1, 0)));
        products.add(new Product(6, "SLOGAN T-SHIRT", 20, new Stock(9, 2, 5)));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
