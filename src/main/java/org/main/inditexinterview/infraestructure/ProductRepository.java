package org.main.inditexinterview.infraestructure;

import org.main.inditexinterview.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
}