package org.main.inditexinterview.infraestructure;

import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> products;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Product1", 10, new Stock(5, 10, 3)));
        products.add(new Product(2, "Product2", 5, new Stock(8, 12, 0)));
        products.add(new Product(3, "Product3", 8, new Stock(15, 5, 20)));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
